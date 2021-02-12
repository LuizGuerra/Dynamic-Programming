import Foundation

func naiveGridTraveler(_ m: Int, _ n: Int) -> Int {
    if m == 0 || n == 0 {
        return  0
    }
    if m == 1 && n == 1 {
        return  1
    }
    return naiveGridTraveler(m-1, n) + naiveGridTraveler(m, n-1)
}

func dynamicMemoizationGridTraveler(_ m: Int, _ n: Int) -> Double {
    var memo: [String:Double] = [:]
    func travel(_ m: Int, _ n: Int, _ memo: inout [String:Double]) -> Double {
        if m == 0 || n == 0 {
            return  0
        }
        if m == 1 && n == 1 {
            return  1
        }
        let key = m > n ? "\(n)-\(m)" : "\(m)-\(n)"
        if let value = memo[key] {
            return value
        }
        let value = travel(m-1, n, &memo) + travel(m, n-1, &memo)
        memo[key] = value
        return value
    }
    return travel(m, n, &memo)
}

func dynamicTabularGridTraveler(_ m: Int, _ n: Int) -> Double {
    var table: [[Double]] = []
    for i in 0 ..< m {
        table.append([])
        for _ in 0 ..< n { 
            table[i].append(0)
        }
    }
    table[0][0] = 1
    for i in 0 ..< m {
        for j in 0 ..< n { 
            let value: Double = table[i][j]
            if i < m-1 {
                table[i+1][j] += value
            }
            if j < n-1 {
                table[i][j+1] += value
            }
        }
    }
    return table[m-1][n-1]
}