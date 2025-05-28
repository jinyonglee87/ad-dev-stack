function update() {
  const now = new Date();
  const year = now.getFullYear();
  const month = now.getMonth() + 1;
  const day = now.getDate();
  const hour = now.getHours().toString().padStart(2, "0");
  const minute = now.getMinutes().toString().padStart(2, "0");
  const second = now.getSeconds().toString().padStart(2, "0");

  let dayWeek = now.getDay();
  const weekdays = ["일", "월", "화", "수", "목", "금", "토"];
  dayWeek = weekdays[dayWeek];

  // Date display
  const dateToday = `${year}년 ${month}월 ${day}일 (${dayWeek})`;
  document.getElementById("date").textContent = dateToday;

  // Clock display
  const liveClock = `${hour} : ${minute} : ${second}`;
  document.getElementById("clock").textContent = liveClock;
}

function liveCountdown() {
  const now = new Date();
  const newyear = new Date("2026-01-01T00:00:00");
  let totalSeconds = Math.floor((newyear - now) / 1000);

  const days = Math.floor(totalSeconds / (60 * 60 * 24));
  totalSeconds %= 60 * 60 * 24;
  const hours = Math.floor(totalSeconds / (60 * 60));
  totalSeconds %= 60 * 60;
  const minutes = Math.floor(totalSeconds / 60);
  const seconds = totalSeconds % 60;

  document.getElementById(
    "newYear"
  ).textContent = `올해 남은시간은 ${days}일, ${hours}시간, ${minutes}분, ${seconds}초`;
}

function randomBackground() {
  const body = document.body;
  const r = Math.floor(Math.random() * 256);
  const g = Math.floor(Math.random() * 256);
  const b = Math.floor(Math.random() * 256);
  body.style.background = `rgba(${r}, ${g}, ${b}, 0.4)`;
}
import quotes from "../04_JS/실습05_quotes.js";

function randomQuotes() {
  console.log(quotes[0].en);
  console.log(quotes[0].ko);

  const random = quotes[Math.floor(Math.random() * quotes.length)];
  const quoteE = document.querySelector("#quoteE");
  const quoteK = document.querySelector("#quoteK");
  quoteE.innerHTML = random.en;
  quoteK.innerHTML = random.ko;
}
// Initial calls
update();
liveCountdown();
randomBackground();
randomQuotes();

// Set intervals
setInterval(update, 1000);
setInterval(liveCountdown, 1000);
setInterval(randomBackground, 3000);
setInterval(randomQuotes, 10000);
