## はじめに

業務でVisitarパターンを実装する機会があり、はっきりと理解していなかったので、学習したことをまとめたものなります。

## 概要

Visitorパターンはデータ構造と処理を分離することができます。

Visitorパターンでは、データを保持するクラスとアルゴリズムを実装するクラス(Visitorクラス)に分けます。

もし、アプリケーション内にデータ構造があり、いくつかのアルゴリズムがそのデータ構造にアクセスする場合には、

Visitorパターンを利用することで、データ構造はデータの保持とアクセスに集中することができます。

既存のクラスを修正することなく、機能を拡張できます。(オープン・クローズドの原則)

## 背景

データ構造の中に多くの要素が格納されており、その各要素に対して、何らかの処理をしたい。

この時、「処理」のコードはどこに書けばいいだろうか。
データ構造を表しているクラスの中に書く、とすると
**新しい処理が必要になるたびに、データ構造のクラスを修正しなければならない。**

上記の問題を解決するために、Visitorパターンが有用とされています。

## 特徴

[Java言語で学ぶデザインパターン入門](https://www.amazon.co.jp/dp/B00I8ATHGW)によれば、データ構造のクラスとアルゴリズムを記述するクラスには、以下に示すような関係性があります。

データ構造を保持するクラスを `Visitable` クラスとし、データ構造に対してアルゴリズムを記述するクラスを `Visitor` クラスとします。

`Visitor` クラスには `visit(visitable)` メソッドを定義します。
`visit()` 内では、データ構造のクラスの属性や振る舞いにアクセスしながら、アルゴリズムを記述するようにします。

一方、 `Visitable` クラスには `accept(visitor)` メソッドを定義します。
`accept(visitor)` 内では、**引数で渡されたVisitorオブジェクトの `visit()` を呼び出します。**

上記で説明したコードを書くと以下のようになります。

## サンプルコード

データ構造のクラス(Visitableクラス)を記述します。
リスト型のデータを保持するクラスと辞書型のデータを保持するクラスを記述しています。
それぞれのクラスにVisitorクラスを受け入れるメソッド( `accept()` )を定義します。

```visitable.py
class VisitableList(list):

    def accept(self, visitor):
        visitor.visit_list(self)

class VisitableDict(dict):

    def accept(self, visitor):
        visitor.visit_dict(self)

``` 

次に、アルゴリズムを記述するVisitorクラスを記述します。
以下のコードでは、先に記述したデータ構造のクラスで保持するデータを単純に標準出力するようにします。

```visitor.py
class Printer(object):
    def visit_list(self, instance):
        print('リストの中身: {}'.format(instance))

    def visit_dict(self, instance):
        print('辞書の中身のキー: {}'.format(
            ', '.join(instance.keys())
        ))

```

次に、データ構造のクラスとVisitorクラスを以下のサンプルコードのように使用します。
データ構造のクラスのオブジェクトを生成して、
`データ構造のオブジェクト.accept(Visitorオブジェクト)` 
のように記述します。

```main.py

def main():

    vistitable_list = VisitableList([1, 2, 3, 5])
    vistitable_list.accept(Printer())
    vistitable_dict = VisitableDict({'one': 1, 'two': 2, 'three': 3})
    vistitable_dict.accept(Printer())

if __name__ == "__main__":

    main()

``` 

```bash
$ python main.py
リストの中身: [1, 2, 3, 5]
辞書の中身のキー: one, two, three
```

### イントロスペクションの特性を利用してVisitorクラスとVisitableクラスを接続

イントロスペクションとは、対象物(今回はオブジェクト)について、その素質やカバーする範囲、
可能なことを範囲するために、調査できる機能のことを指します。

例えば、オブジェクトに対して「どのようなプロパティを持っているか」を参照や取得したりすることをイントロスペクションと呼びます。

次のコードはイントロスペクションの特性を活かして、VisitableクラスとVisitorクラスを接続するクラスを記述しています。

``` python
class Connect():
    def __init__(self, visited, vistor):
        self.__cls = visited.__class__.__name__
        self.__method_name = 'visit_%s' % self.__cls
        self.__method = getattr(vistor, self.__method_name, None)
        
        # visit()を実装 
        self.__method(visited)
```

`vistied.__class.___name__` 、や `getattr()` がイントロスペクションにあたります。

以下のコードで、先に記述したPrinterクラスも使用して実装します。

```main.py
if __name__ == "__main__":

    Connect([1, 2, 3], Printer())

``` 

```bash
$ python main.py
リストの中身: [1, 2, 3]
辞書の中身のキー: one, two, three
```

イントロスペクションを使用することで、Visitableクラスにaccept()を実装する必要がなくなります。

