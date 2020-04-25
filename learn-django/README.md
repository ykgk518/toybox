# Djagoに本格入門する

# startprojectコマンドで作成されるファイルについて

## 環境について

環境は以下に通り。

* Python 3.7
* Windows 
* Django 3.0


### プロジェクトで作成されるファイルの全体像

```console
> django-admin startproject sampleproject
> cd sampleproject
> tree /f
C:.
│  manage.py
│
└─sampleproject
        asgi.py
        settings.py
        urls.py
        wsgi.py
        __init__.py
```



## manage.py

Djangoが提供する管理コマンドはmanage.py経由で実行できる。開発、運用時に頻繁に使用される。

自分でDjangoの管理コマンドを作ることが可能で、それらのコマンド実行時もmanage.py経由で実行される。
自作の場合、`django.core.base.BaseCommand`を継承して、各アプリケーションディレクトリ内の`management/commands`配下にモジュールを配下すればOK。

## __init__.py

モジュールをパッケージ化するおまじないてきなファイル。
中身は空。


## `wsgi.py`
WSGIインターフェースに対応したWebサーバもしくはWebアプリケーションとDjangoプロジェクトを紐づけるためのモジュール。

`application = get_wsgi_application()`により接続。

```wsgi.py
import os

from django.core.wsgi import get_wsgi_application

os.environ.setdefault('DJANGO_SETTINGS_MODULE', 'sampleproject.settings')

application = get_wsgi_application()

```


## asgi.py

Django3.0から追加された
[asgiについて](https://asgi.readthedocs.io/en/latest/)

## `settings.py`

プロジェクト固有の設定を記述する設定ファイル。

[詳細はこちらのリファレンス](https://docs.djangoproject.com/ja/3.0/ref/settings/)

`settings.py`について変数とその概要を以下に記述。

|変数| 概要|
|---|---|
|DEBUG | デバック情報を表示するか否か|
|ALLOWED_HOSTS | リクエストを受け付ける外部のWebサーバを指定する場所|
|INSTALLED_APPS | アプリケーションの定義|
|MIDDLEWARE | ミドルウェアの設定|
|ROOT_URLCONF | リクエストを受け付けたときにはじめに呼び出すファイルを指定|
|TEMPLATES | htmlファイル等の静的ファイルの場所を指定|
|WSGI_APPLICATION|WSGIファイルがどこに入っているか指定|
|DATABASES|指定するデータベースに関する設定情報|
|AUTH_PASSWORD_VALIDATORS　| パスワードに対する精査パターンを指定|
|LANGUAGE_CODE | 言語の種類|
|TIME_ZONE | タイムゾーンの設定|
|USE_I18N | 国際化対応(多言語化機能)|
|USE_L10N | ローカライゼーション機能を有効にするかどうか|
|USE_TZ | タイムゾーンの変換機能の有効にするかどうか|
|STATIC_URL | CSSや画像ファイルの保存先、どういったURLが呼び出されるか|


## `url.py`
URLのパターンに対応するビューに紐づけるためのモジュール。
startprojectコマンドで作成されたurls.pyでは、
`urlpatterns`変数には、アプリケーション配下にあるurls.pyをつなぐようにパスを追加する場合がおおい。


```urls.py
from django.contrib import admin
from django.urls import path, include

urlpatterns = [
    path('admin/', admin.site.urls),
    # 「todo」というアプリのurls.pyにつなげる
    path('', include('todo.urls')),
]

```

**クラスを指定する場合は`クラス名.as_view()`を指定する**

