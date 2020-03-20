from visit import ListVisitor
from file_enrty import File
from directory_entry import Directory


def main():
    print('Making root entries')
    rootdir = Directory('root')
    bindir = Directory('bin')
    tmpdir = Directory('tmp')
    usrdir = Directory('usr')
    rootdir.add(bindir)
    rootdir.add(tmpdir)
    rootdir.add(usrdir)
    bindir.add(File('vi', 1000))
    bindir.add(File('latex', 2000))
    rootdir.accept(ListVisitor())


if __name__ == "__main__":
    main()
