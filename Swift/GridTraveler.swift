
func naiveGridTraveler(_ m: Int, _ n: Int) -> Int {
    if m == 0 || n == 0 {
        return  0
    }
    if m == 1 && n == 1 {
        return  1
    }
    return naiveGridTraveler(m-1, n) + naiveGridTraveler(m, n-1)
}

