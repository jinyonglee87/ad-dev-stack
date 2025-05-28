window.addEventListener("DOMContentLoaded", () => {
  const box = document.querySelector(".container #box");
  const bgImage = window.getComputedStyle(box).backgroundImage;
  const url = bgImage.slice(33, -2);
  for (let i = 0; i < bgImage.length; i++) {}

  console.log(url);

  const roll = document.querySelector("#roll");
  roll.addEventListener("click", (e) => {
    alert("클릭 이벤트 발생!");
  });

  const reRoll = document.querySelector("#reRoll");
  reRoll.addEventListener("click", (e) => {
    alert("re클릭 이벤트 발생!");
  });

  const randombox = [1, 2, 3];
  const randombox1 = [1, 2, 3];
  const randombox2 = [1, 2, 3];
  const randomValue = randombox[Math.floor(Math.random() * randombox.length)];
  console.log(randomValue);
  const randomValue1 =
    randombox1[Math.floor(Math.random() * randombox1.length)];
  console.log(randomValue1);
  const randomValue2 =
    randombox2[Math.floor(Math.random() * randombox2.length)];
  console.log(randomValue2);

  if (randomValue === 1) {
    box.style.width = `300px`;
  } else if (randomValue === 2) {
    box.style.width = `400px`;
  } else if (randomValue === 3) {
    box.style.width = `500px`;
  } else if (randomValue1 === 1) {
    box2.style.width = `300px`;
  } else if (randomValue1 === 2) {
    box2.style.width = `400px`;
  } else if (randomValue1 === 3) {
    box2.style.width = `500px`;
  }
});

// function randomBackground() {
//   const body = document.body;
//   const r = Math.floor(Math.random() * 256);
//   const g = Math.floor(Math.random() * 256);
//   const b = Math.floor(Math.random() * 256);
//   body.style.background = `rgba(${r}, ${g}, ${b}, 0.4)`;
// }
