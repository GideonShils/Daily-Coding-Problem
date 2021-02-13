/*
*  DAY 10:
* 
*  Implement a job scheduler which takes in a function f and an integer n, and calls f after n milliseconds.
* 
*/

const functionToRun = () => {
  console.log("I've been run!");
}


const main = () => {
  const millis = 5000;
  console.log(`I'll call the function in ${millis} milliseconds`);
  callAfterMillis(functionToRun, millis);
}

const callAfterMillis = (functionToRun, millis) => {
  setTimeout(functionToRun, millis);
}

main();