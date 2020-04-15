from visit import ListVisitor
from directory_entry import Directory


if __name__ == "__main__":
    print('Making root entries')

    rootdir = Directory('root')
    bindir = Directory('bin')
    tmpdir = Directory('tmp')
    usrdir = Directory('usr')
    rootdir.add(bindir)
    tmpdir.add(usrdir)
    rootdir.add(tmpdir)
    # 一覧表示
    print("--------------")
    rootdir.accept(ListVisitor())
    tmpdir.accept(ListVisitor())
