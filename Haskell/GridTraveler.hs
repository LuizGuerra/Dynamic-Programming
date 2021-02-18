gridTraveler :: Int -> Int -> Int
gridTraveler m n    | m == 0 || n == 0 = 0
                    | m == 1 && n == 1 = 1
                    | otherwise = gridTraveler (m-1) n + gridTraveler m (n-1)

main :: IO()
main = do
    putStrLn "Grid Traveler naive implementation"
    putStrLn (show (gridTraveler 2 2))
    putStrLn (show (gridTraveler 3 2))
    putStrLn (show (gridTraveler 3 3))