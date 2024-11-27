function formatDate(lastUpdated) {
  var date = new Date(lastUpdated);
  var year = date.getFullYear();
  var month = ("0" + (date.getMonth() + 1)).slice(-2); // Month is 0-indexed, so add 1
  var day = ("0" + date.getDate()).slice(-2);
  var hours = ("0" + date.getHours()).slice(-2);
  var minutes = ("0" + date.getMinutes()).slice(-2);
  var seconds = ("0" + date.getSeconds()).slice(-2);
  return `${year}-${month}-${day} ${hours}:${minutes}:${seconds} HKT`;
}

$(document).ready(function() {
  setInterval(function() {
    // ajax
    $.ajax({
      url: "/web/coin",
      type: "GET",
      success: function(data) { // data = coins
        console.log(data); // sysout
        data.forEach(function(coin, index) {
          var row = $(`tr[data-coin-id='${coinData.id}']`);
          if (row.length) {
            // jQuery
            // update current_price -> js is running on client-side
            row.find("td:nth-child(2)").text("$" + coinData.current_price.toFixed(2).toLocalString());
            // update market_cap
            row.find("td:nth-child(4)").text("$" + coinData.market_cap.toLocalString());
            // update last_updated (HKT)
            row.find(".last_updated").text(formatDate(coinData.last_updated));
            // update price_change
            var priceClass = 
              coinData.price_change_percentage_24h > 0
              ? "up"
              : coinData.price_change_percentage_24h < 0
              ? "down"
              : "neutral";
            var priceChangeIcon = 
              coinData.price_change_percentage_24h > 0
              ? "▲"
              : coinData.price_change_percentage_24h < 0
              ? "▼"
              : "-";
            var priceChangeValue = Math.abs(coinData.price_change_percentage_24h).toFixed(2) + "%";
            row
              .find(".price-change")
              .removeClass("up down neutral")
              .addClass(priceClass)
              .html(`${priceChangeIcon} ${priceChangeValue}`);
          }
        });
      }
    });
  }, 30000); // 30 seconds
});