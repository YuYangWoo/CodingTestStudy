#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	// ������ ������ ���� N����
	int N;
	// ������ �ߵ� �� �ִ� ���Ը� ���� vector v����
	vector<int> v;
	// �ְ� ���Ը� ���� answer����
	int answer = 0;
	// ������ ���� �Է� �ޱ�
	cin >> N;
	// ���� ���� ��ƿ �� �ִ� �߷��̸� ��� �������� �� ��ŭ �� ��ƿ �� �ֱ� ������ ȿ���� ������ �������� ����Ͽ� �ϳ��� �ٿ������� ���� a ����
	int a = N;
	// ������ ��ƿ �� �ִ� �߷��� v�� ����
	for (int i = 0; i < N; i++) {
		int a;
		cin >> a;
		v.push_back(a);
	}
	// ���� ���� ��ƿ �� �ִ� �߷��� ���� ���� ����ϱ� ���� �������� ����
	sort(v.begin(), v.end());
	// N�� ������ ���� ���� ���� ��ƿ �� �ִ� ������ �߷��� ���缭 �ٸ� �����鵵 
	// �� ��ŭ�� �� �� �ֱ� ������ �� �߷��� * a(�ְ� �߷��� ���ؾ� �ϱ� ������ ���� �ͺ��� �ٿ�������)�� answer�� ���� �� answer���� ū ���̸� �����Ѵ�.
	for (int i = 0; i < N; i++) {
		if (answer < v[i] * (N - i)) answer = v[i] * (N - i);
	}

	// �ְ��߷� answer Print
	cout << answer;
}