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
    rootdir.accept(ListVisitor())
    print("--------------")
    tmpdir.accept(ListVisitor())
