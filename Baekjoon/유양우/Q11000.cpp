#include <iostream>
#include <algorithm>
#include <math.h>
#include <vector>
#include <queue>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int N; cin >> N;
	// vector pair 선언
	vector<pair<int, int>> time;
	// 오름차순을 우선으로 하는 우선순위큐 선언(Head가 항상 작은 값이 오게끔)
	priority_queue<int, vector<int>, greater<int> > pq;
	// vector pair 값 입력받기
	for (int i = 0; i < N; i++) {
		int start; cin >> start;
		int end; cin >> end;
		time.push_back(make_pair(start, end));
	}
	// pair의 first값을 오름차순으로 정렬 -> 최소의 강의실을 사용해야하기 때문에 시작시간을 기준으로 오름차순 정렬
	sort(time.begin(), time.end());
	// 첫 번째 끝나는 시간을 우선순위 큐에 enque
	pq.push(time[0].second);
	for (int i = 1; i < N; i++) {
		// 시작시간이 우선순위큐에 있는 값보다 크면 pop 
		if (pq.top() <= time[i].first) {
			pq.pop();
		}
		// 후에 그 끝나는 시간을 넣어준다.
		pq.push(time[i].second);
	}
	// 우선순위 큐의 사이즈를 출력한다
	cout << pq.size();
}