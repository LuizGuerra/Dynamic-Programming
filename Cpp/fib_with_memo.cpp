#include<bits/stdc++.h>
using namespace std;

#define ll long long

ll mem[200];

ll fib(ll n){
    if(n<=1) return n;
    if(mem[n]!=-1)return mem[n];
    mem[n] = fib(n-1)+fib(n-2);
    return mem[n];
    
}

int main(){
    memset(mem,-1,sizeof(mem));
    ll n;
    std::cin >> n;
    std::cout << fib(n) << std::endl;
    
    
    
    return 0;
}