(function () {
  var KEY = 'fragen-forum-theme';
  var mq = window.matchMedia('(prefers-color-scheme: dark)');

  function apply(theme) {
    var isDark = theme === 'dark' || (theme === 'system' && mq.matches);
    document.documentElement.setAttribute('data-theme', isDark ? 'dark' : 'light');
  }

  function stored() {
    return localStorage.getItem(KEY) || 'system';
  }

  function setTheme(theme) {
    localStorage.setItem(KEY, theme);
    apply(theme);
    document.querySelectorAll('[data-theme-btn]').forEach(function (btn) {
      btn.classList.toggle('active', btn.getAttribute('data-theme-btn') === theme);
    });
  }

  apply(stored());

  mq.addEventListener('change', function () {
    if (stored() === 'system') apply('system');
  });

  document.addEventListener('DOMContentLoaded', function () {
    var current = stored();
    document.querySelectorAll('[data-theme-btn]').forEach(function (btn) {
      btn.classList.toggle('active', btn.getAttribute('data-theme-btn') === current);
      btn.addEventListener('click', function () {
        setTheme(this.getAttribute('data-theme-btn'));
      });
    });
  });
})();
