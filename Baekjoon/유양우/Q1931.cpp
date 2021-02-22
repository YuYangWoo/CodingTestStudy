#include <iostream>
#include <algorithm>
#include <math.h>
#include <vector>
using namespace std;

// 종료시간 오름차순으로 정렬 비교 cmp
bool cmp(const pair<int, int>& a, const pair<int, int>& b) {
	if (a.second == b.second) {
		return a.first < b.first;
	}
	return a.second < b.second;
}

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int N; cin >> N;
	// vector pair 선언 및 초기화
	vector<pair<int, int>> time;
	for (int i = 0; i < N; i++) {
		int start; cin >> start;
		int end; cin >> end;
		time.push_back(make_pair(start, end));
	}
	// 초기 count 값 선언
	int cnt = 1;
	// 시작시간을 오름차순으로 정렬한 후 끝나는 시간을 정렬
	sort(time.begin(), time.end());
	sort(time.begin(), time.end(), cmp);

	// 첫 회의 끝나는시간을 대입
	int end = time[0].second;

	for (int i = 1; i < N; i++) {
		// 시작시간이 끝나는시간보다 크면 cnt 1증가 및 해당 인덱스 끝나는시간을 대입 후 비교연산
		if (time[i].first >= end) {
			cnt++;
			end = time[i].second;
		}
	}
	cout << cnt;
}