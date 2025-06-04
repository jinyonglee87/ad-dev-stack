// lotto-to-csv.js
// const fs = require('fs');
// const fetch = require('node-fetch');
import fs from "fs";
import fetch from "node-fetch";

const BASE_URL =
  "https://www.dhlottery.co.kr/common.do?method=getLottoNumber&drwNo=";
const MAX_DRAW = 1178;
const RESULT_FILE = "lotto_results.csv";

(async () => {
  const rows = [
    ["drawNo", "date", "num1", "num2", "num3", "num4", "num5", "num6", "bonus"],
  ];

  for (let i = 1; i <= MAX_DRAW; i++) {
    try {
      const res = await fetch(`${BASE_URL}${i}`);
      const data = await res.json();

      if (data.returnValue === "success") {
        const row = [
          data.drwNo,
          data.drwNoDate,
          data.drwtNo1,
          data.drwtNo2,
          data.drwtNo3,
          data.drwtNo4,
          data.drwtNo5,
          data.drwtNo6,
          data.bnusNo,
        ];
        rows.push(row);
        console.log(`Fetched draw ${i}`);
      } else {
        console.warn(`Draw ${i} not available`);
      }
    } catch (err) {
      console.error(`Error on draw ${i}:`, err.message);
    }
  }

  // Convert to CSV string
  const csv = rows.map((row) => row.join(",")).join("\n");

  // Write to file
  fs.writeFileSync(RESULT_FILE, csv, "utf8");
  console.log(`✅ CSV saved to ${RESULT_FILE}`);
})();
