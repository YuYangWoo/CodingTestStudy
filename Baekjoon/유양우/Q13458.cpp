#include <iostream>
#include <algorithm>
#include <math.h>
#include <vector>
using namespace std;
int main() {
	// 시험장의 개수 응시자의 수가 1,000,000명까지기에 모든 변수를 long long으로 선언한다.
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	long long N; cin >> N; // 시험장의 개수 선언 및 초기화
	// 지원자 벡터 선언 및 응시자의 수 초기화
	vector<long long> applicant;
	for (int i = 0; i < N; i++) {
		int n; cin >> n;
		applicant.push_back(n);
	}
	// 총감독관과 부감독관이 맡을 수 있는 응시자의 수 선언 및 초기화
	long long B; cin >> B;
	long long C; cin >> C;
	// 최소 필요한 감독관의 수 sum 선언
	long long sum = 0;
	// 시험장의 개수까지
	for (int i = 0; i < N; i++) {
		applicant[i] -= B; // 모든 배열에서 총감독관이 맡을 수 있는 학생을 빼고 sum++
		sum++;
		if (applicant[i] > 0) { // 감시되어야 할 지원자가 남아있다면
			if ((applicant[i] % C) == 0) { // 남은 지원자에서 부감독관이 감시할 수 있는 C를 나누어 나머지가 0 이면 applicant[i]/C를 더해주고
				sum += (applicant[i] / C);
			}
			else { // 나머지가 0이아니면 1만큼 더 더해준다.
				sum += ((applicant[i] / C)) + 1;
			}
		}
	}
	cout << sum;
}