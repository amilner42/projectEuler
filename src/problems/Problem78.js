import R from "ramda";

/**
 * This serves as the entry point to your application.
 */
let main = () => {
  console.log("Hello world");

  // console.log(getNumberOfCombinations(10,10));
  for (let index = 1; true; index++) {
    console.log(index);
    let numberOfCombinations = getNumberOfCombinations(index, index);
    if(numberOfCombinations % 10E6 == 0) {
      break;
    }
  }
}


var results = {};
const getNumberOfCombinations = (numberOfBalls, maxGroupSize) => {

  const hash = `${numberOfBalls}.${maxGroupSize}`;

  if(results[hash] != undefined) {
    return results[hash];
  }


  if(maxGroupSize == 1) {
    results[hash] = 1;
    return 1;
  }

  let totalSum = 1;
  let maxNumberOfBallsToKeep = numberOfBalls;

  for (let i = 2; i <= R.min(maxNumberOfBallsToKeep, maxGroupSize); i++) {
    totalSum += getNumberOfCombinations(numberOfBalls - i, i) % 10E6;
  }

  results[hash] = totalSum;
  return totalSum;
}

export default main;
