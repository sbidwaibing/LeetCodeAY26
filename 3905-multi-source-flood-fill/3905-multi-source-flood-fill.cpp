class Solution {

#define pii pair<int, int>
static constexpr int dir[5] = {-1,0,1,0,-1};

public:
    vector<vector<int>> colorGrid(int n, int m, vector<vector<int>>& sources) {
        
        sort(sources.begin(), sources.end(), [](const vector<int>& a, const vector<int>& b){
            return a[2]>b[2];
        });

        vector<vector<int>> grid(n, vector<int>(m));
        queue<pii> q;

        for(auto& source : sources){
            q.push({source[0], source[1]});
            grid[source[0]][source[1]] = source[2];
        }

        while(!q.empty()){
            auto[x, y] = q.front();
            q.pop();

            for(int d = 0; d < 4; d++){
                int newX = x + dir[d];
                int newY = y + dir[d+1];

                if(newX >= 0 and newY >= 0 and newX < n and newY < m and grid[newX][newY] == 0){
                    grid[newX][newY] = grid[x][y];
                    q.push({newX, newY});
                }
            }
        }

        return grid;

    }
};