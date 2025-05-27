const now = new Date();
const year = now.getFullYear();
const month = now.getMonth() + 1;
const day = now.getDate();
const time = now.getTime();
const hour = now.getHours();
const minute = now.getMinutes();
const second = now.getSeconds();
const newyear = new Date("2026-01-01T00:00:00");
let dayWeek = now.getDay();

switch (dayWeek) {
  case 1:
    dayWeek = "월";
    break;
  case 2:
    dayWeek = "화";
    break;
  case 3:
    dayWeek = "수";
    break;
  case 4:
    dayWeek = "목";
    break;
  case 5:
    dayWeek = "금";
    break;
  case 6:
    dayWeek = "토";
    break;
  case 7:
    dayWeek = "일";
    break;
}
console.log(`${year}년 ${month}월 ${day}일 (${dayWeek})`);
console.log(`${hour} : ${minute} : ${second}`);
// console.log(newyear);
console.log(`올해 남은시간은 ${newyear - now}`);
const countdown = (newyear - now) / 1000 / 60 / 60 / 24; // 초 -> 분 -> 시간 -> 일
