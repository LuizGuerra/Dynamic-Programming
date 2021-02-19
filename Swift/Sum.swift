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

func naiveHowSum(targetSum: Int, numbers: [Int]) -> [Int]? {
    if targetSum < 0 {
        return nil
    }
    if targetSum == 0 {
        return []
    }
    for number in numbers {
        guard var result = naiveHowSum(targetSum: targetSum - number, numbers: numbers) else { continue }
        result.append(number)
        return result
    }
    return nil
}

func dynamicMemoHowSum(targetSum: Int, numbers: [Int]) -> [Int]? {
    var memo: [Int:[Int]?] = [:]
    func howSum(_ targetSum: Int, _ numbers: [Int], _ memo: inout [Int:[Int]?]) -> [Int]? {
        if let value = memo[targetSum] {
            return value
        }
        if targetSum < 0 {
            return nil
        }
        if targetSum == 0 {
            return []
        }
        for number in numbers {
            guard var result = howSum(targetSum - number, numbers, &memo) else { continue }
            result.append(number)
            memo[targetSum] = result
            return result
        }
        memo[targetSum] =  nil
        return nil
    }
    return howSum(targetSum, numbers, &memo)
}

func dynamicTabularHowSum(targetSum: Int, numbers: [Int]) -> [Int]? {
    var tabulation: [[Int]?] = [[]]
    for _ in 0 ..< targetSum {
        tabulation.append(nil)
    }
    for i in 0 ... targetSum {
        for number in numbers {
            let index = i+number
            guard let array = tabulation[i] else { continue }
            if index > targetSum {
                continue
            }

            let list = [number] + array
            if index == targetSum {
                return list
            }
            tabulation[index] = list
        }
    }
    return nil
}

/**
* ===============================================================
*                          BEST SUM  
*                    optimization problem                    
* ===============================================================
*/

func naiveBestSum(targetSum: Int, numbers: [Int]) -> [Int]? {
    if targetSum < 0 {
        return nil
    }
    if targetSum == 0 {
        return []
    }
    var shortest: [Int]? = nil
    for number in numbers {
        guard var combination = naiveBestSum(targetSum: targetSum - number, numbers: numbers) else { continue }
        combination.append(number)
        if shortest == nil || shortest!.count > combination.count {
            shortest = combination
        }
    }
    return shortest
}

func dynamicMemoBestSum(targetSum: Int, numbers: [Int]) -> [Int]? {
    var memo: [Int:[Int]?] = [:]
    func bestSum(_ targetSum: Int, _ numbers: [Int], _ memo: inout [Int:[Int]?]) -> [Int]? {
        if let value = memo[targetSum] {
            return value
        }
        if targetSum < 0 {
            return nil
        }
        if targetSum == 0 {
            return []
        }
        var shortest: [Int]? = nil
        for number in numbers {
            guard var combination = bestSum(targetSum - number, numbers, &memo) else { continue }
            combination.append(number)
            if shortest == nil || shortest!.count > combination.count {
                shortest = combination
            }
        }
        memo[targetSum] = shortest
        return shortest
    }
    return bestSum(targetSum, numbers, &memo)
}

func dynamicTabularBestSum(targetSum: Int, numbers: [Int]) -> [Int]? {
    var table: [[Int]?] = [[]]
    for _ in 0 ..< targetSum {
        table.append(nil)
    }
    for i in 0 ... targetSum {
        for number in numbers {
            let index = i + number
            guard let array = table[i] else { continue }
            if index > targetSum {
                continue
            }
            let list = [number] + array
            if table[index] == nil || table[index]!.count > list.count {
                table[index] = list
            }
        }
    }
    return table[targetSum]
}