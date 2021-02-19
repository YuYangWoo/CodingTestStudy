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
	// �� ���� ������ ��� ���� �ְ� �߷��� �� �� ���� ��� vector answer ����
	vector<int> answer;
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
	// �� ��ŭ�� �� �� �ֱ� ������ �� �߷��� * a(�ְ� �߷��� ���ؾ� �ϱ� ������ ���� �ͺ��� �ٿ�������)�� answer�� �����ϰ� a--�� �ϳ��� �ٿ�������.
	for (int i = 0; i < N; i++) {
		answer.push_back(v[i] * a);
		a--;
	}
	// answer�� �� �� �ִ� ���� ���� �߷����� ���� ū �߷����� ��� �ֱ� ������ answer�� �������� ����
	sort(answer.begin(), answer.end());
	// answer�� �ε����� N-1�� �� ���� ũ�Ƿ� ����Ʈ
	cout << answer[N - 1];

}