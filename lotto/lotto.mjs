// lotto.mjs or "type": "module"
const URL = "https://www.dhlottery.co.kr/common.do?method=getLottoNumber&drwNo=";

async function fetchLotto(drawNo) {
  const res = await fetch(`${URL}${drawNo}`);
  const data = await res.json();
  console.log(`Draw ${drawNo}:`, [
    data.drwtNo1,
    data.drwtNo2,
    data.drwtNo3,
    data.drwtNo4,
    data.drwtNo5,
    data.drwtNo6,
    `+ Bonus: ${data.bnusNo}`
  ].join(", "));
}

fetchLotto(1174); // Example draw number