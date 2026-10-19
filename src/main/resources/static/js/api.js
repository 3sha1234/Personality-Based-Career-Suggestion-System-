// API Configuration
const API_BASE = 'http://localhost:8080/api';

// ===== AUTH HELPERS =====
function getToken() { return localStorage.getItem('token'); }
function getUser()  { return JSON.parse(localStorage.getItem('user') || 'null'); }
function isLoggedIn() { return !!getToken(); }

function logout() {
  localStorage.clear();
  sessionStorage.clear();
  window.location.href = "/login.html";
}

function saveAuth(data) {
  localStorage.setItem('token', data.token);
  localStorage.setItem('user', JSON.stringify({
    id: data.userId, username: data.username,
    email: data.email, fullName: data.fullName, role: data.role
  }));
}

// ===== API FETCH WRAPPER =====
async function apiCall(endpoint, method = 'GET', body = null, auth = false) {
  const headers = { 'Content-Type': 'application/json' };
  if (auth) headers['Authorization'] = `Bearer ${getToken()}`;

  const config = { method, headers };
  if (body) config.body = JSON.stringify(body);

  const res = await fetch(`${API_BASE}${endpoint}`, config);
  const data = await res.json();

  if (!res.ok) throw new Error(data.error || 'Something went wrong');
  return data;
}

// ===== AUTH API =====
const AuthAPI = {
  register: (username, email, password, fullName) =>
    apiCall('/auth/register', 'POST', { username, email, password, fullName }),

  login: (username, password) =>
    apiCall('/auth/login', 'POST', { username, password }),
};

// ===== TEST API =====
const TestAPI = {
  getQuestions: () => apiCall('/questions'),
  submit: (answers) => apiCall('/test/submit', 'POST', { answers }, true),
  getLatest: () => apiCall('/test/latest', 'GET', null, true),
  getHistory: () => apiCall('/test/history', 'GET', null, true),
};

// ===== CAREERS API =====
const CareerAPI = {
  getAll: () => apiCall('/careers'),
  getByPersonality: (type) => apiCall(`/careers/by-personality/${type}`),
};

// ===== ADMIN API =====
const AdminAPI = {
  getStats: () => apiCall('/admin/stats', 'GET', null, true),
  getUsers: () => apiCall('/admin/users', 'GET', null, true),
  getCareers: () => apiCall('/admin/careers', 'GET', null, true),
  createCareer: (data) => apiCall('/admin/careers', 'POST', data, true),
  updateCareer: (id, data) => apiCall(`/admin/careers/${id}`, 'PUT', data, true),
  deleteCareer: (id) => apiCall(`/admin/careers/${id}`, 'DELETE', null, true),
  getQuestions: () => apiCall('/admin/questions', 'GET', null, true),
  createQuestion: (data) => apiCall('/admin/questions', 'POST', data, true),
  deleteQuestion: (id) => apiCall(`/admin/questions/${id}`, 'DELETE', null, true),
};

// ===== NAV HELPERS =====
function updateNav() {
  const user = getUser();
  const navAuth = document.getElementById('nav-auth');
  const navUser = document.getElementById('nav-user');

  if (!navAuth) return;

  if (user) {
    if (navAuth) navAuth.style.display = 'none';
    if (navUser) {
      navUser.style.display = 'flex';
      const nameEl = document.getElementById('nav-username');
      if (nameEl) nameEl.textContent = user.fullName || user.username;
    }
  } else {
    if (navAuth) navAuth.style.display = 'flex';
    if (navUser) navUser.style.display = 'none';
  }
}

// Personality colors & icons
const PERSONALITY = {
  ANALYTICAL: { color: '#7c6aff', bg: 'rgba(124,106,255,0.1)', icon: '🔬', label: 'Analytical' },
  CREATIVE:   { color: '#ff6a9e', bg: 'rgba(255,106,158,0.1)', icon: '🎨', label: 'Creative' },
  SOCIAL:     { color: '#6affcc', bg: 'rgba(106,255,204,0.1)', icon: '🤝', label: 'Social' },
  LEADERSHIP: { color: '#ffb86a', bg: 'rgba(255,184,106,0.1)', icon: '🚀', label: 'Leadership' },
  PRACTICAL:  { color: '#6aaeff', bg: 'rgba(106,174,255,0.1)', icon: '🔧', label: 'Practical' },
};
