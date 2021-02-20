#include<bits/stdc++.h>

using namespace std;
#define ll long long

bool mem[51];


bool canSum(ll targetSum, ll arr[],ll n){
    if(targetSum == 0 ) return true;
    if(targetSum<0) return false;
    if(mem[targetSum]!=-1) return mem[targetSum];
    for(int i=0;i<n;i++){
        ll rem = targetSum-arr[i];
        if(canSum(rem,arr,n)==true){
            mem[targetSum]=true;
            return mem[targetSum];
        }
        
        
    }
    mem[targetSum]=false;
    return false;
    
    
}


int main()
{
    memset(mem,-1,sizeof(mem));
    ll arr[] ={7,14};
    if(canSum(300,arr,2)){
        std::cout << "true" << std::endl;
    }
    else std::cout << "false" << std::endl;

    return 0;
}
