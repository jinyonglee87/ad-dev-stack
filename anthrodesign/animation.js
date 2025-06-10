document.addEventListener("DOMContentLoaded", () => {
  const main = document.querySelector("main"); //this is not a div but a semantics tag
  const top = document.querySelector(".top");
  const left = document.querySelector(".left");
  const right = document.querySelector(".right");
  const bottom = document.querySelector(".bottom"); //this is a div

  // 🚫 Immediately cancel transition to avoid animating from old transform
  main.style.transition = "none";
  main.style.transform = "none";

  // ✅ Re-enable transition shortly after reset
  requestAnimationFrame(() => {
    requestAnimationFrame(() => {
      main.style.transition = "transform 1s cubic-bezier(0.4, 0.2, 0.2, 1)";
    });
  });

  // Transform utility
  function transformMain(x = "0", y = "0", z = "0") {
    main.style.transform = `perspective(800px) rotateX(0deg) translate3d(${x}, ${y}, ${z})`;
  }

  // Event handlers
  document.getElementById("top").onclick = () => {
    transformMain("0", "50vh", "-300px");
    top.style.visibility = "visible";
  };
  document.getElementById("bottom").onclick = () => {
    transformMain("0", "-50vh", "-300px");
    bottom.style.visibility = "visible";
  };
  document.getElementById("left").onclick = () =>
    transformMain("30vh", "0", "0px");
  document.getElementById("right").onclick = () =>
    transformMain("-30vh", "0", "-50px");
  document.getElementById("top-close").onclick = () => {
    top.style.visibility = "hidden";
    transformMain("0", "0", "0");
  };
  document.getElementById("bottom-close").onclick = () => {
    transformMain("0", "0", "0");
    bottom.style.visibility = "hidden";
  };
});
