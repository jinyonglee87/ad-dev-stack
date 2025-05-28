// DOMContentLoaded 이벤트는 HTML 문서의 구조가 완전히 로드된 후 발생
window.addEventListener("DOMContentLoaded", () => {
  const h1 = document.querySelector("h1");
  h1.style.color = "blue";

  const click = document.querySelector("#click");
  click.addEventListener("click", () => {
    // 클릭 이벤트가 일어나면 행하고자 하는 코드 작성
    alert("클릭 이벤트 발생!");
    console.log(event);
    // click 색상을 변경
    click.style.background = "hotpink";
  });

  const double = document.querySelector("#double");
  double.addEventListener("dblclick", () => {
    alert("더블클릭 이벤트 발생!");
    console.log(event);
  });

  const right = document.querySelector("#right");
  right.addEventListener("contextmenu", () => {
    //alert("우클릭 이벤트 발생!");
    console.log(event);
    event.preventDefault(); //우클릭 박지
  });

  const hover = document.querySelector("#hover");
  hover.addEventListener("mouseenter", () => {
    console.log("entered");
    //배경색상은 light blue, 텍스트는 mouse enter 변경
    hover.style.background = "lightblue";
    hover.textContent = "Mouse ENTER";
  });
  hover.addEventListener("mouseleave", () => {
    //배경색상은 navy
    console.log("left");
    hover.style.background = "navy";
    hover.textContent = "Mouse Leave!";
  });

  // 폼 이벤트

  // input live print event
  const input = document.querySelector("#input");
  input.addEventListener("input", (e) => {
    console.log(e.target.value);
    document.querySelector("#inputResult").textContent = input.value;
  });

  // form select event
  const select = document.querySelector("#select");
  select.addEventListener("change", () => {
    console.log(select.value);
    document.querySelector("#selectResult").textContent = select.value;
  });

  //
  const form = document.querySelector("#form");
  form.addEventListener("submit", (e) => {
    // 값이 없는 경우만 전송 불가, 값이 있으면 전송!
    e.preventDefault();

    const input = document.querySelector("#input");
    console.log(input.value);
  });

  // form text field event
  // key event: keydown, keypress, keyup
  const keyboard = document.querySelector("#keyboard");
  keyboard.addEventListener("keydown", (e) => {
    console.log(e.key);
    if (e.key === "Enter") {
      document.querySelector("#keyResult").textContent = keyboard.value;
    }
  });

  // moving box
  const move = document.querySelector(".moveBox");
  let x = 0,
    y = 0;
  document.addEventListener("keydown", (e) => {
    if (e.key === "ArrowUp") {
      // top: -인 경우
      y -= 40;
      move.style.top = `${y}px`;
    } else if (e.key === "ArrowDown") {
      // left: -인 경우
      y += 40;
      move.style.top = `${y}px`;
    } else if (e.key === "ArrowLeft") {
      x -= 40;
      move.style.left = `${x}px`;
    } else if (e.key === "ArrowRight") {
      x += 40;
      move.style.left = `${x}px`;
    }
  });

  // scroll event
  const wheel = document.querySelector("#wheel");
  const scroll = document.querySelector("#scroll");
  window.addEventListener("wheel", (e) => {
    //console.log(e.deltaY);
    // wheeling up -100
    if (e.deltaY < 0) wheel.textContent = "휠 위로";
    else if (e.deltaY > 0) wheel.textContent = "휠 아래로";
    // wheeling down + 100
  });

  // scroll load effect
  window.addEventListener("scroll", (e) => {
    console.log("scrollHeight", document.documentElement.scrollHeight); //page body max-height
    console.log("innerHeight", window.innerHeight); //page body current height
    console.log("scrollY", window.scrollY);
    // scrollHeight === innerHeight + scrollY
    // scrollHeight - innerHeight : 스크롤 총 내리는 높이
    const totalHeight =
      document.documentElement.scrollHeight - window.innerHeight;

    const percent = (window.scrollY / totalHeight) * 100;
    console.log(parseInt(percent), "%");

    scroll.style.width = `${percent}%`;
  });

  // 이벤트 위임
  // 이미지가 클릭될 때마다 해당 이미지 지우기
  // 1. 이미지마다 이벤트 걸려면 반복문 필요!
  //   const img = document.querySelectorAll(".container img");
  //   console.log(img);
  //   for (let i = 0; i < img.length; i++) {
  //     img[i].addEventListener("click", (e) => {
  //       //   img[i].style.display = "none";
  //       console.log(e.currentTarget);
  //       e.currentTarget.style.display = "none";
  //     });
  //   }

  // 2. 부모인 컨테이너에 이벤트 걸기
  const container = document.querySelector(".container");
  const removeHandler = (e) => {
    if (e.target !== e.currentTarget) {
      e.target.style.display = "none";
    }
    console.log("target", e.target); //내가 클릭한 이미지
    console.log("current", e.currentTarget); // 이벤트 걸린 본인
  };
  container.addEventListener("click", removeHandler);
});
