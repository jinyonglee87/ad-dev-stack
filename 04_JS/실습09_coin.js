const fetchData = async () => {
  const response = await fetch("https://api.upbit.com/v1/market/all");
  const data = await response.json();
  const krwMarkets = data.filter((item) => item.market.includes("KRW"));
  const tickerResponse = await fetch(
    `https://api.upbit.com/v1/ticker?markets=${krwMarkets
      .map((item) => item.market)
      .join(",")}`
  );
  const tickerData = await tickerResponse.json();

  const markets = krwMarkets.map((item) => item.market).join(",");
  console.log(markets);

  const marketsElement = document.getElementById("markets");
  krwMarkets.forEach((item) => {
    const ticker = tickerData.find((ticker) => ticker.market === item.market);
    marketsElement.innerHTML += `<h2>${item.korean_name} (${item.market})</h2>
     <p>현재가: ${ticker.trade_price.toLocaleString()}원</p>
     <p>24시간 거래량: ${ticker.acc_trade_volume_24h.toFixed(2)}</p>
     전일대비: ${
       ticker.change === "RISE"
         ? "상승"
         : ticker.change === "FALL"
         ? "하락"
         : "보합"
     }</p>`;
  });

  // forEach + 내가 원하는 형태로 가공하고자 할때 -> map
  //   krwMarkets.forEach((item) => {
  //     market.innerHTML += `<h2>${item.korean_name} (${item.market})</h2>`;
  //     let markets = "";
  //     krwMarkets.forEach((item) => {
  //       markets += item.market + ",";
  //     });
  //     console.log(markets.slice(0, -1));
  //     console.log(tickerData);
  //   });

  //   data.forEach((item) => {
  //     if (item.market.includes("KRW"))
  //       //.includes("KRW") filteres KRW
  //       // or .startsWith("KRW") begins with KRW
  //       market.innerHTML += `<h2>${item.korean_name} (${item.market})</h2>`;
  //   });

  // forEach + if -> filter

  // for (let i = 0; i < data.length; i++) {
  //     console.log(data[i]);
  // }

  //   market.innerHTML = data
  //     .slice(0, 99)
  //     .map((item) => `${item.korean_name} (${item.market}) `)
  //     .join("<br>");

  // for (let i = 0; i < data.length; i++) {
  // console.log(data[i]);

  // >>async<< function dataFetch() {}
  // const dataFetch = >>async<< function() {}
  // async comes in front of function

  // API: https://api.upbit.com/v1/ticker?markets=KRW-BTC,BTC-ETH
};
