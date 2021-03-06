const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

let groupWordsCount = input[0];

for(let i = 1; i <= input[0]; i++) {
    let alreadyExist = new Set([]);
    let currentString = input[i][0];
    alreadyExist.add(currentString);
    for(let j = 1; j < input[i].length; j++) {
        if(input[i][j] != currentString) {
            if(alreadyExist.has(input[i][j])) {
                groupWordsCount -= 1;
                break;
            } else {
                alreadyExist.add(input[i][j]);
            }
        } 
        currentString = input[i][j];
    }
}

console.log(groupWordsCount);