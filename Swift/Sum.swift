import Foundation

/**
* ===============================================================
*                          CAN SUM  
*                      decision problem                       
* ===============================================================
*/

func naiveCanSum(targetSum: Int, numbers: [Int]) -> Bool {
    if targetSum < 0 {  
        return false
    }
    if targetSum == 0 {
        return true
    }
    for number in numbers {
        if naiveCanSum(targetSum: targetSum - number, numbers: numbers) {
            return true
        }
    }
    return false
}

func dynamicMemoCanSum(targetSum: Int, numbers: [Int]) -> Bool {
    var memo: [Int:Bool] = [:]
    func canSum(_ targetSum: Int, _ numbers: [Int], _ memo: inout [Int:Bool]) -> Bool {
        if let value = memo[targetSum] {
            return value
        }
        if targetSum < 0 {  
            return false
        }
        if targetSum == 0 {
            return true
        }
        for number in numbers {
            if canSum(targetSum - number, numbers, &memo) {
                memo[targetSum] = true
                return true
            }
        }
        memo[targetSum] = false
        return false
    }
    return canSum(targetSum, numbers, &memo)
}

 func dynamicTabularCanSum(targetSum: Int, numbers: [Int]) -> Bool {
    var table: [Bool] = []
    for _ in 0 ... targetSum {
        table.append(false)
    }
    table[0] = true
    for i in 0 ..< targetSum {
        for number in numbers {
            if table[i] && i+number <= targetSum {
                table[i+number] = true
            }
        }
    }
    return table[targetSum]
 }

/**
* ===============================================================
*                          HOW SUM  
*                    combinatoric problem                       
* ===============================================================
*/

/**
* ===============================================================
*                          HOW SUM  
*                    optimization problem                    
* ===============================================================
*/