#include<bits/stdc++.h>
using namespace std;

#define ll long long

ll mem[100][100];

ll grid(ll m,ll n){
    if(m==1 && n==1) return 1;
    if(m==0 || n==0)return 0;
    if (mem[m][n]!=-1) return mem[m][n];
    
    	
    
    mem[m][n] = grid(m-1,n)+grid(m,n-1);

    return mem[m][n];
    
}

int main(){
	
     ll m,n;
     cout<<"Enter m n:"<<endl;
     cin>>m>>n;

     memset(mem,-1,sizeof(mem));
    

      std::cout << grid(m,n) << std::endl;
   
    return 0;
}