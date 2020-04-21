# Djagoに本格入門する

# StartaProjectでDjagoに必要なファイル群をコピーしよう

```
$ django-admin startproject helloworldproject
$
```

```bash
$ python3 manage.py runserver
Watching for file changes with StatReloader
Performing system checks...

System check identified no issues (0 silenced).

You have 17 unapplied migration(s). Your project may not work properly until you apply the migrations for app(s): admin, auth, contenttypes, sessions.
Run 'python manage.py migrate' to apply them.

March 15, 2020 - 15:12:29
Django version 3.0.4, using settings 'helloworldproject.settings'
Starting development server at http://127.0.0.1:8000/
Quit the server with CONTROL-C.
```

## startprojectコマンドで作成されるファイルについて
### `wsgi.py`

### `settings.py`

* DEBUG : デバック情報を表示するか否か
* ALLOWED_HOSTS : リクエストを受け付ける外部のWebサーバを指定する場所
* INSTALLED_APPS : 機能ごとにアプリを作っていく訳であるが、作成したアプリをDjagoに認識させる
* MIDDLEWARE : セッションに関する情報を保持するための
* ROOT_URLCONF : リクエストを受け付けたときに初めに呼び出すファイルを指定する
* TEMPLATES : htmlファイル等の静的ファイルの場所を指定する
* :WSGIファイルがどこに入っているか指定
* :指定するデータベースに関する設定情報
* AUTH_PASSWORD_VALIDATORS　: パスワードに対する精査パターンを指定
* LANGUAGE_CODE : 言語の種類
* TIME_ZONE :
* USE_I18N : 
* USE_L10N : 
* USE_TZ : 
* STATIC_URL : CSSや画像ファイルの保存先、どういったURLが呼び出されるか

### `url.py`
Webサーバからのリクエストに基づいて
`urlpatterns`に基づいて、指令を決める

**クラスを指定する場合は`クラス名.as_view()`を指定する**

### `views.py`
デフォルトでは`views.py`はない。
`url.py`から送られるリクエストオブジェクトを受け取って、レスポンスオブジェクトを返す。

`template_name`変数の存在→`settings.py`の`template`変数に指示
