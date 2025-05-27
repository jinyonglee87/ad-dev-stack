// 태그로 가져오기 : 같은 태그로 여러개일 수 있으므로 배열로 반환

function btn1() {
  console.log(document.body);

  // 모든 div 태그들 가져오기
  const divs = document.getElementsByTagName("div");
  const h1 = document.getElementsByTagName("h1");
  const testClass = document.getElementsByClassName("testClass");
  console.log(divs);
  console.log(divs[0]); // 첫번째 div
  console.log(h1);
}

// id로 가져오기 : 고유한 id로 하나의 태그 선택
function btn2() {
  const testId = document.getElementById("testId");
  const testId2 = document.getElementById("testId2");
  console.log(testId);
  console.log(testId2);
}

// class로 가져오기 : 같은 클래스명이 여러개일 수 있으므로 배열로 반환
function btn3() {
  const div = document.getElementsByClassName("testClass");
  console.log(div);
  console.log(div[1]);
  console.log(div[2]);
}

// name으로 가져오기 : 같은 name 속성이 여러개일 수 있으므로 배열로 반환
function btn4() {
  const div = document.getElementsByName("testName");
  console.log(div);
}

//querySelector
// 한개만 불러오고싶다면 querySelector
// 여러개만 불러오고싶다면 querySelectorAll
function btn5() {
  const div = document.querySelector("#testId");
  console.log(div);

  const divs = document.querySelectorAll("div");
  console.log(divs);
}

//내용 조작하기
function btn6() {
  const divs = document.querySelectorAll(".testClass");
  console.log(divs);

  divs[0].textContent = "<span>안녕하세요</span>"; // inserts tag as plain text
  divs[1].innerHTML = "<span>안녕하세요</span>"; // inserts and edits html
  console.log(divs[0].innerHTML); //<span> => &lt;span&gt;
  console.log(divs[1].innerHTML); //<span> => <span>, thus html tag is activated
}

//속성 조작하기
function btn7() {
  const div = document.querySelector("#testId");
  console.log(div);

  //속성 추가
  div.setAttribute("data-test", "테스트"); // .setAttribute("property","value")
  //속성 값 가져오기
  console.log(div.getAttribute("data-test")); // data-test 불러오기
  console.log(div.getAttribute("class")); // .class 불러오기
  console.log(div.getAttribute("id")); // #id 불러오기
}

//스타일 조작하기
function btn8() {
  const div = document.querySelector("#testId");
  console.log(div);

  div.style.color = "orange";
  div.style.backgroundColor = "yellow";
}

//classlist 사용하기: add, remove, contains, toggle
const div2 = document.querySelector("#testId2"); //function밖에 const 두면 전역에서 선택

//add
function btn9() {
  div2.classList.add("black"); //black 클래스 추가
}

function btn10() {
  div2.classList.remove("black"); //black 클래스 제거
}

//contains and toggle
function btn11() {
  const has = div2.classList.contains("black"); // contains : black 클래스가 있는지 확인
  console.log("black 클래스가 있는지?", has);
}
// black클래스가 있다면 제거, 없다면 추가
function btn12() {
  const has = div2.classList.contains("black");
  if (has) {
    div2.classList.remove("black");
    console.log("제거됨");
  } else {
    div2.classList.add("add");
    console.log("추가됨");
  }
  console.log("check", has);
}

//toggle
function btn12() {
  div2.classList.toggle("black");
}

//문석 객체 추가하기
function btn13() {
  const div = document.querySelector("#testId3");
  const p = document.createElement("p"); // p tag 생성
  p.textContent = "텍스트 추가"; // p tag 추가 + 텍스트 내용 추가
  div.appendChild(p); //div안에 p 추가 + 텍스내용 추가
}

//문서 객체 삭제하기
function btn14() {
  const testId3 = document.querySelector("#testId3");
  const p = document.querySelector("#testId3 p"); //p가 생성됬음으로 #testId3+p
  //   testId3.removeChild(p); //부모를 삭제하는 v.1
  p.remove(); //부모를 삭제하는 v.2
  if (p !== null) p.remove();
}
