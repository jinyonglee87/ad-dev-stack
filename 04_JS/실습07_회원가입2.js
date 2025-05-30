const signup = document.querySelector("#signup");
const fields = [
  {
    id: "id",
    exp: /^[a-zA-Z0-9]{4,12}$/,
    message: "영문자로 시작하고 영문자와 숫자 조합으로 4~12자 이내",
  },
  {
    id: "pw",
    exp: /^(?=.*[a-zA-Z])(?=.*[0-9]).{8,16}$/,
    message: "영문자, 숫자, 특수문자 조합으로 8~15자 이내",
  },
  {
    id: "repw",
    message: "비밀번호와 동일하게 입력해주세요",
  },
  {
    id: "name",
    exp: /^[가-힣]{2,4}$/,
    message: "한글 2자 이상 입력해주세요",
  },
  {
    id: "email",
    exp: /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/,
    message: "이메일 형식에 맞게 입력해주세요",
  },
  {
    id: "phone",
    exp: /^01[0-9]-\d{3,4}-\d{4}$/,
    message: "전화번호 형식에 맞게 입력해주세요 (예: 010-1234-5678)",
  },
];

fields.forEach((id, exp, message, check) => {
  const input = document.querySelector(`#${id}`);
  const message = document.querySelector(`#${id}`);
  const regExp = exp;
  const password = document.querySelector("#pw");
  const passRegExp = fields[1].exp;
});

if (id === "repw") {
}

if (regExp.test(input.value)) {
  //   맞음
  check = true;
  message.style.color = "green";
  checkmark6.innerHTML = "<img src='../asset/check.svg'/>";
} else if (e.target.value === "") {
  //   빈 문자열일 때
  check = false;
  message.style.color = "black";
  checkmark6.innerHTML = "";
} else {
  //   틀림
  check = false;
  message.style.color = "red";
}

// every: 배열 안에 특정 조건이 모두 만족할 경우 true
signup.disabled = !fields.every((field) => fields.check === true);
