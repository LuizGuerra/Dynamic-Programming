/**
* ===============================================================
*                         CAN CONSTRUCT           
*                        decision problem                        
* ===============================================================
*/

func naiveCanConstruct(target: String, wordBank: [String]) -> Bool {
    if target.isEmpty {
        return true
    }
    for word in wordBank {
        if target.hasPrefix(word) {
            var str = target
            str.removeFirst(word.count)
            if naiveCanConstruct(target: str, wordBank: wordBank) {
                return true 
            }
        }
    }
    return false
}

func dynamicMemoCanConstruct(target: String, wordBank: [String]) -> Bool {
    var memo: [String:Bool] = [:]
    func canConstruct(_ target: String, _ wordBank: [String], _ memo: inout [String:Bool]) -> Bool {
        if let value = memo[target] {
            return value
        }
        if target.isEmpty {
            return true
        }
        for word in wordBank {
            if !target.hasPrefix(word) {
                continue
            }
            var str = target
            str.removeFirst(word.count)
            if canConstruct(str, wordBank, &memo) {
                memo[target] = true
                return true
            }
        }
        memo[target] = false
        return false
    }
    return canConstruct(target, wordBank, &memo)
}

func dynamicTabularCanConstruct(target: String, wordBank: [String]) -> Bool {
    var tabulation = [true]
    for _ in 0 ..<  target.count {
        tabulation.append(false)
    }
    
    for i in 0 ..< target.count {
        if !tabulation[i] {
            continue
        }
        var str = target
        str.removeFirst(i)
        for word in wordBank {
            if str.hasPrefix(word) {
                tabulation[i + word.count] = true
            }
            if tabulation[target.count] {
                return true
            }
        }
    }
    return false
}

/**
* ===============================================================
*                          COUNT CONSTRUCT                         
*                       combinatoric problem                     
* ===============================================================
*/

extension String {
    func removeFirst(_ word: String) -> String {
        var str = self
        str.removeFirst(word.count)
        return str
    }
}

func naiveCountConstruct(target: String, wordBank: [String]) -> Int {
    if target.isEmpty { 
        return 1
    }
    var sum = 0
    for word in wordBank {
        if target.hasPrefix(word) {
            sum += naiveCountConstruct(target: target.removeFirst(word), wordBank: wordBank)
        }
    }
    return sum
}

func dynamicMemoCountConstruct(target: String, wordBank: [String]) -> Int {
    var memo: [String:Int] = [:]
    func countConstruct(_ target: String, _ wordBank: [String], _ memo: inout [String:Int]) -> Int {
        if let value = memo[target] {
            return value
        }
        if target.isEmpty {
            return 1
        }
        var sum = 0;
        for word in wordBank {
            if target.hasPrefix(word) {
                sum += countConstruct(target.removeFirst(word), wordBank, &memo)
            }
        }
        memo[target] = sum
        return sum
    }
    return countConstruct(target, wordBank, &memo)
}

func dynamicTabularCountConstruct(target: String, wordBank: [String]) -> Int {
    var tabulation: [Int] = [1]
    for _ in 0 ..< target.count {
        tabulation.append(0)
    }
    for i in 0 ..< target.count {
        if tabulation[i] == 0 {
            continue
        }
        var word = target
        word.removeFirst(i)
        for prefix in wordBank where word.hasPrefix(prefix) {
            tabulation[i+prefix.count] = tabulation[i] + tabulation[i+prefix.count]
        }
    }
    return tabulation[target.count]
}

/**
* ===============================================================
*                        ALL CONSTRUCTS  
*                      optimization problem                    
* ===============================================================
*/

func naiveAllConstruct(target: String, wordBank: [String]) -> [[String]] {
    if target.isEmpty {
        return [[]]
    }
    var result: [[String]] = []
    for prefix in wordBank where target.hasPrefix(prefix) {
        let sufixWays: [[String]] = naiveAllConstruct(target: target.removeFirst(prefix), wordBank: wordBank)
            .map { [prefix] + $0 }
        result += sufixWays
    }
    return result
}

func dynamicMemoAllConstruct(target: String, wordBank: [String]) -> [[String]] {
    var memo: [String:[[String]]] = [:]
    func allConstruct(_ target: String, _ wordBank: [String], _ memo: inout [String:[[String]]]) -> [[String]] {
        if let value = memo[target] {
            return value
        }
        if target.isEmpty {
            return [[]]
        }
        var result: [[String]] = []
        for prefix in  wordBank where target.hasPrefix(prefix) {
            let sufixWays = allConstruct(target.removeFirst(prefix), wordBank, &memo)
                .map { [prefix] + $0 }
            result += sufixWays
        }
        memo[target] = result
        return result
    }
    return allConstruct(target, wordBank, &memo)
}

func dynamicTabularAllConstruct(target: String, wordBank: [String]) -> [[String]] {
    var tabulation: [[[String]]] = [[[]]]
    for _ in 0 ..< target.count {
        tabulation.append([])
    }
    for i in 0 ... target.count where !tabulation[i].isEmpty {
        var word = target
        word.removeFirst(i)
        for prefix in wordBank where word.hasPrefix(prefix) {
            tabulation[i+prefix.count] += tabulation[i].map { $0 + [prefix] }
        }
    }
    return tabulation[target.count]
}
