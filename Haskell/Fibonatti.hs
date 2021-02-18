import Data.List

naiveFib :: Int -> Int
naiveFib 0 = 0
naiveFib 1 = 1
naiveFib n = (naiveFib (n-1)) + (naiveFib (n-2))




concat' :: [Int] -> String
concat' [] = ""
concat' (x:xs:[]) = show x ++ ", " ++ show xs
concat' (x:xs) = show x ++ ", " ++ concat' xs

main :: IO()
main = do
    putStrLn "Fibonacci naive implementation"
    putStrLn (concat' (map naiveFib [1..10]))
