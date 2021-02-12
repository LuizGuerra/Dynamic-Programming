import Foundation

func naiveFibonacci(_ n: Int) -> Int {
    if n < 2 { return 1 }
    return naiveFibonacci(n-1) + naiveFibonacci(n-2)
}

func dynamicMemoFibonacci(_ n: Int) -> Double {
    var memo: [Double:Double] = [:]
    func dynamicMemoFibonacci(_ n: Double, _ memo: inout [Double:Double]) -> Double {
        if let value = memo[n] {
            return value
        }
        if n <= 2 {
            return 1
        }
        let value = dynamicMemoFibonacci(n-1, &memo) + dynamicMemoFibonacci(n-2, &memo)
        memo[n] = value
        return value;
    }
    return dynamicMemoFibonacci(Double(n), &memo)
}

func dynamicTabularFibonacci(_ n: Int) -> Double {
    var list: [Double] = []
    for i in 0 ... n {
        list.append(0)
    }
    list[1] = 1
    for i in 0 ..< n {
        list[i+1] += list[i]
        if i+2 <= n {
            list[i+2] += list[i]
        }
    }
    return list[n]
}

