from visitor import VisitableList, VisitableDict, Printer, Visit


def main():
    # Visitorクラスがaccpetメソッドを実装する場合
    vistitable_list = VisitableList([1, 2, 3, 5])
    vistitable_list.accept(Printer())
    vistitable_dict = VisitableDict({'one': 1, 'two': 2, 'three': 3})
    vistitable_dict.accept(Printer())

    # VisitorクラスとVisitableクラスを動的に接続する
    Visit([1, 2, 3], Printer())


if __name__ == "__main__":
    main()
