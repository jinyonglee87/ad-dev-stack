// 1번 문제
function printText() {
  const div = document.querySelector("#result1");
  const p = document.createElement("p");
  p.textContent = "안녕하세요!";
  div.appendChild(p);
}

// 1 answer
// const result1 = document.querySelector("#result1");
// function printText() {
//   result1.innerHTML = "안녕하세요!!";
// }

// 2번 문제
// const customer = document.querySelector("#customer");
// function printInputValue() {
//   console.log(customer.value);
//   const div = document.querySelector("#result2");
//   const p = document.createElement("p");
//   p.textContent = customer.value;
//   div.appendChild(p);
// }

// 2 answer
const result2 = document.querySelector("#result2");
const customer = document.querySelector("#customer");
function printInputValue() {
  console.log(customer.value);
  result2.textContent = customer.value;
  customer.value = "";
}
// 3번 문제
function changeColor() {
  const divclass = document.querySelector(".div-test");
  divclass.style.backgroundColor = "orange";
}

// 4번 문제
function stringLength() {
  const textlength = document.querySelector("#text");
  const div = document.querySelector("#result4");
  const p = document.createElement("p");

  p.textContent = textlength.value.length;
  div.appendChild(p);
  textlength.value = "";
}

// 5번 문제
function stringSplit() {
  const la = document.querySelector("#la");
  console.log(la.textContent.split(","));

  la.innerHTML =
    "<ul><li>사과</li><li>바나나</li><li>오렌지</li><li>포도</li></ul>";
}

// 5 answer
// const la = document.querySelector("#la");
// const result5 = document.querySelector("#result5");
// function stringSplit() {
//   // 1. "사과, 바나나, 오렌지, 포도" 문자 가지고 오기
//   console.log(la.innerHTML);
//   const laText = la.innerHTML;
//   // 2. 가지고 온 문자열 분리하기 -> 배열로 만들기
//   const laArr = laText.split(",");

//   // 3. ul 태그 만들기
//   const ul = document.createElement("ul");

//   console.log(laArr);
//   // 4. 배열 값 하나씩 가지고 오기 -> 반복문!
//   for (let i = 0; i < laArr.length; i++) {
//     console.log(laArr[i]);
//     // 5. 반복문에서 태그를 만들어서 출력
//     const li = document.createElement("li");
//     // 6. li 태그에 값 넣기
//     li.innerHTML = laArr[i];
//     console.log(li);
//     // 7. ul 태그에 만들어놓은 li 태그들 추가하기
//     // ul.appendChild(li);
//     // ul.innerHTML = "<li>" + laArr[i] + "</li>";
//     ul.innerTHML += `<li>${laArr}</li>`;
//   }
//   console.log(ul);
//   result5.appendChild(ul);
// }

// 6번 문제
function arrayTest() {
  //   const food = preview.textContent.split(",");
  //   console.log(food);
  // console.log(preview.textContent);
  // 피자 치킨 떡복이 <- 배열로 만들기
  const preview = document.querySelector("#preview");
  const preArr = preview.textContent.split(",");
  // 1. 일단 반복문 해보자
  //   for (i = 0; i < preArr.length; i++) {
  //     // 2. 이미 가지고 있는 값에서 내가 삭제할 값이 일치하면 배열에서 제거
  //     console.log(preArr[i] === "피자");
  //     if (preArr[i] === "remove.value") {
  //       preArr.splice(i, 1);
  //     }
  //   }
  //   console.log(preArr.join(" "));
  //   preview.textContent = preArr.join(" ");
  // 2. 배열에서 제거 : splice(인덱스, 1);
  const delIdx = preArr.indexOf(removeEventListener.value);
  //if (delIdx !== -1) preArr.splice(delIdx, 1);

  // +) 추가

  console.log(preArr.includes(remove.value));
  if (preArr.includes(remove.value)) preArr.splice(delIdx, 1);

  preArr.push(add.value);

  //   //배열 -> 문자열로 바꾸기
  console.log(preArr.join(" "));
  preview.textContent = preArr.join(" ");
}

// 7번 문제
// promt로 이름, 나이, 주소 순으로 입력받아서 출력 (총3명)
const names = document.querySelectorAll(".name");
const ages = document.querySelectorAll(".age");
const addrs = document.querySelectorAll(".addr");
function addStudent() {
  console.log(names);
  for (let i = 0; i < 3; i++) {
    const name = prompt(`${i}번째 학생 이름`);
    const age = prompt(`${i}번째 나이`);
    const addr = prompt(`주소: ${i}`);
    names[i].textContent = name;
    ages[i].textContent = age;
    addrs[i].textContent = addr;
  }
}

// 8번
const list = document.querySelector("#list");
function addItem() {
  // 1. li 태그를 만들어서 추가하는 방식
  const li = document.createElement("li");
  li.textContent = "test";
  list.appendChild(li);

  // 2. innerHTML로 문자로 추가하는 방식
  list.innerHTML += "<li>test v2</li>";
}

function removeItem() {
  // 1. 부모에서 제거 v1
  //   console.log(list.childNodes);
  //   list.removeChild(list.childNodes[0]);
  // 2. 본인이 제거 v2
  const li = document.querySelector("#list li");
  li.remove();
}

// 9번
const result9 = document.querySelector("#result9");
function toggleClass() {
  result9.classList.toggle("active");
}

// 10번
const item = document.querySelector("#item");
const price = document.querySelector("#price");
const cart = document.querySelector("#cart");
const total = document.querySelector("#total span");

let sum = 0;
function addToCart() {
  cart.innerHTML += `<li>${item.value} ----- $ ${price.value}</li>`;

  console.log(isNaN(Number(price.value))); // 숫자 기입란에 문자 넣으면 NaN
  if (!isNaN(Number(price.value))) sum += Number(price.value);
  total.innerHTML = sum;
  console.log(sum);
  item.value = "";
  price.value = "";
}
