window.addEventListener("DOMContentLoaded", () => {
  const click = document.querySelector("section button:first-child");
  // click : 클릭 이벤트를 걸어야 하는 버튼
  const img = document.querySelectorAll("img");
  // img : 클릭을 했을때 봐꿔야 하는 이미지
  const span = document.querySelector("button span");

  const reroll = document.querySelector("section button:Last-child");

  // 게임 함수
  let count = 0;
  const game = () => {
    // 랜덤값 : 1 ~ 3 까지 랜덤값
    const random = [
      Math.floor(Math.random() * 3) + 1,
      Math.floor(Math.random() * 3) + 1,
      Math.floor(Math.random() * 3) + 1,
    ];
    for (let i = 0; i < img.length; i++) {
      img[i].setAttribute("src", `../asset/spy${random[i]}.jpg`);
    } // 클릭할 때마다 카운트 증가
    span.innerHTML = ++count;

    // 이미지 3개가 일치한 경우 버튼 disabled 처리
    // 1. click.setAttribute("disabled", "disabled");
    // 2. click.disabled = true;
    const h2 = document.querySelector("h2");
    if (random[0] === random[1] && random[1] === random[2]) {
      click.disabled = true;
      h2.style.visibility = "visible";
    }
    // click.setAttribute("disabled", true);
    // h2에 visibility: visible로 변경
  };

  const end = () => {
    const h2 = document.querySelector("h2");
    // 이미지는 처음 그대로 1, 2, 3 순서대로 보이게 하고
    for (let i = 0; i < img.length; i++) {
      img[i].setAttribute("src", `../asset/spy${i + 1}.jpg`);
    }
    // count는 0으로 초기화
    span.innerHTML = "";

    // h2 visibility: hidden으로 변경
    h2.style.visibility = "hidden";
    click.disabled = false;
  };

  click.addEventListener("click", game);
  reroll.addEventListener("click", end);
  //("click", () => {location.reload()};
});
