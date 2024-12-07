const fs = require("fs");
const path = require("path");

const filePath = path.join(
  process.env.HOME || process.env.USERPROFILE,
  "day1_input.txt"
);

const arr1 = [];
const arr2 = [];
const arr3 = [];

fs.readFile(filePath, "utf8", (err, data) => {
  if (err) {
    console.error("Error reading file:", err);
    return;
  }

  const lines = data.split("\r\n");
  for (const line of lines) {
    const [num1, num2] = line.trim().split(/\s+/).map(Number);
    arr1.push(num1);
    arr1.sort();
    arr2.push(num2);
    arr2.sort();
  }

  for (let i = 0; i < arr1.length; i++) {
    let counter = 0;
    for (let j = 0; j < arr2.length; j++) {
      if (arr1[i] === arr2[j]) {
        counter++;
      }
    }
    arr3[i] = arr1[i] * counter;
    counter = 0;
  }
  console.log(arr3.reduce((cur, acc) => cur + acc, 0));
});
