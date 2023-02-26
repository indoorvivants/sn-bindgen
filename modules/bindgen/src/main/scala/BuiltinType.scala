package bindgen

import scala.scalanative.unsafe.*
import scala.scalanative.unsigned.*

import scala.scalanative.*

private def _unsafe(typ: String) = s"scala.scalanative.unsafe.$typ"
private def _scala(typ: String) = s"scala.$typ"
private def _unsigned(typ: String) = s"scala.scalanative.unsigned.$typ"
private def size[T](using t: Tag[T]) = t.size
private def alignment[T](using t: Tag[T]) = t.alignment

case class BuiltinType(
    short: String,
    full: String,
    size: ULong,
    alignment: ULong,
    header: Option[String]
)

object BuiltinType:
  def apply[T: Tag](short: String, full: String, header: String) =
    new BuiltinType(short, full, size[T], alignment[T], Some(header))

  def apply[T: Tag](short: String, full: String) =
    new BuiltinType(short, full, size[T], alignment[T], None)

  val all = List(
    // format: off
    // GENERATEDCODE: START    
    apply[posix.net.`if`.if_nameindex](short = "if_nameindex", full = "posix.net.`if`.if_nameindex", header = "net/if.h"),
    apply[posix.poll.nfds_t](short = "nfds_t", full = "posix.poll.nfds_t", header = "poll.h"),
    apply[posix.poll.pollEvent_t](short = "pollEvent_t", full = "posix.poll.pollEvent_t", header = "poll.h"),
    apply[posix.poll.struct_pollfd](short = "struct_pollfd", full = "posix.poll.struct_pollfd", header = "poll.h"),
    apply[posix.wordexp.wordexp_t](short = "wordexp_t", full = "posix.wordexp.wordexp_t", header = "wordexp.h"),
    apply[posix.locale.locale_t](short = "locale_t", full = "posix.locale.locale_t", header = "locale.h"),
    apply[posix.inttypes.uint8_t](short = "uint8_t", full = "posix.inttypes.uint8_t", header = "inttypes.h"),
    apply[posix.inttypes.uint16_t](short = "uint16_t", full = "posix.inttypes.uint16_t", header = "inttypes.h"),
    apply[posix.inttypes.uint32_t](short = "uint32_t", full = "posix.inttypes.uint32_t", header = "inttypes.h"),
    apply[posix.inttypes.uint64_t](short = "uint64_t", full = "posix.inttypes.uint64_t", header = "inttypes.h"),
    apply[posix.grp.group](short = "group", full = "posix.grp.group", header = "grp.h"),
    apply[posix.time.timespec](short = "timespec", full = "posix.time.timespec", header = "time.h"),
    apply[posix.time.tm](short = "tm", full = "posix.time.tm", header = "time.h"),
    apply[posix.timer.itimerspec](short = "itimerspec", full = "posix.timer.itimerspec", header = "timer.h"),
    apply[posix.sched.cpu_set_t](short = "cpu_set_t", full = "posix.sched.cpu_set_t", header = "sched.h"),
    apply[posix.sched.sched_param](short = "sched_param", full = "posix.sched.sched_param", header = "sched.h"),
    apply[posix.pwd.passwd](short = "passwd", full = "posix.pwd.passwd", header = "pwd.h"),
    apply[posix.nl_types.nl_catd](short = "nl_catd", full = "posix.nl_types.nl_catd", header = "nl_types.h"),
    apply[posix.nl_types.nl_item](short = "nl_item", full = "posix.nl_types.nl_item", header = "nl_types.h"),
    apply[posix.netinet.in.in_addr](short = "in_addr", full = "posix.netinet.in.in_addr", header = "netinet/in.h"),
    apply[posix.netinet.in.sockaddr_in](short = "sockaddr_in", full = "posix.netinet.in.sockaddr_in", header = "netinet/in.h"),
    apply[posix.netinet.in.in6_addr](short = "in6_addr", full = "posix.netinet.in.in6_addr", header = "netinet/in.h"),
    apply[posix.netinet.in.sockaddr_in6](short = "sockaddr_in6", full = "posix.netinet.in.sockaddr_in6", header = "netinet/in.h"),
    apply[posix.netinet.in.ipv6_mreq](short = "ipv6_mreq", full = "posix.netinet.in.ipv6_mreq", header = "netinet/in.h"),
    apply[posix.netdb.addrinfo](short = "addrinfo", full = "posix.netdb.addrinfo", header = "netdb.h"),
    apply[posix.termios.tcflag_t](short = "tcflag_t", full = "posix.termios.tcflag_t", header = "termios.h"),
    apply[posix.termios.cc_t](short = "cc_t", full = "posix.termios.cc_t", header = "termios.h"),
    apply[posix.termios.speed_t](short = "speed_t", full = "posix.termios.speed_t", header = "termios.h"),
    apply[posix.termios.termios](short = "termios", full = "posix.termios.termios", header = "termios.h"),
    apply[posix.sys.utsname.utsname](short = "utsname", full = "posix.sys.utsname.utsname", header = "sys/utsname.h"),
    apply[posix.sys.times.tms](short = "tms", full = "posix.sys.times.tms", header = "sys/times.h"),
    apply[posix.sys.uio.iovec](short = "iovec", full = "posix.sys.uio.iovec", header = "sys/uio.h"),
    apply[posix.sys.time.timeval](short = "timeval", full = "posix.sys.time.timeval", header = "sys/time.h"),
    apply[posix.sys.wait.idtype_t](short = "idtype_t", full = "posix.sys.wait.idtype_t", header = "sys/wait.h"),
    apply[posix.sys.resource.rlim_t](short = "rlim_t", full = "posix.sys.resource.rlim_t", header = "sys/resource.h"),
    apply[posix.sys.resource.rlimit](short = "rlimit", full = "posix.sys.resource.rlimit", header = "sys/resource.h"),
    apply[posix.sys.resource.rusage](short = "rusage", full = "posix.sys.resource.rusage", header = "sys/resource.h"),
    apply[posix.sys.select.fd_set](short = "fd_set", full = "posix.sys.select.fd_set", header = "sys/select.h"),
    apply[posix.sys.un.sockaddr_un](short = "sockaddr_un", full = "posix.sys.un.sockaddr_un", header = "sys/un.h"),
    apply[posix.sys.stat.dev_t](short = "dev_t", full = "posix.sys.stat.dev_t", header = "sys/stat.h"),
    apply[posix.sys.stat.ino_t](short = "ino_t", full = "posix.sys.stat.ino_t", header = "sys/stat.h"),
    apply[posix.sys.stat.mode_t](short = "mode_t", full = "posix.sys.stat.mode_t", header = "sys/stat.h"),
    apply[posix.sys.stat.nlink_t](short = "nlink_t", full = "posix.sys.stat.nlink_t", header = "sys/stat.h"),
    apply[posix.sys.stat.uid_t](short = "uid_t", full = "posix.sys.stat.uid_t", header = "sys/stat.h"),
    apply[posix.sys.stat.gid_t](short = "gid_t", full = "posix.sys.stat.gid_t", header = "sys/stat.h"),
    apply[posix.sys.stat.blksize_t](short = "blksize_t", full = "posix.sys.stat.blksize_t", header = "sys/stat.h"),
    apply[posix.sys.stat.blkcnt_t](short = "blkcnt_t", full = "posix.sys.stat.blkcnt_t", header = "sys/stat.h"),
    apply[posix.sys.stat.stat](short = "stat", full = "posix.sys.stat.stat", header = "sys/stat.h"),
    apply[posix.sys.types.blkcnt_t](short = "blkcnt_t", full = "posix.sys.types.blkcnt_t", header = "sys/types.h"),
    apply[posix.sys.types.blksize_t](short = "blksize_t", full = "posix.sys.types.blksize_t", header = "sys/types.h"),
    apply[posix.sys.types.clock_t](short = "clock_t", full = "posix.sys.types.clock_t", header = "sys/types.h"),
    apply[posix.sys.types.clockid_t](short = "clockid_t", full = "posix.sys.types.clockid_t", header = "sys/types.h"),
    apply[posix.sys.types.dev_t](short = "dev_t", full = "posix.sys.types.dev_t", header = "sys/types.h"),
    apply[posix.sys.types.fsblkcnt_t](short = "fsblkcnt_t", full = "posix.sys.types.fsblkcnt_t", header = "sys/types.h"),
    apply[posix.sys.types.fsfilcnt_t](short = "fsfilcnt_t", full = "posix.sys.types.fsfilcnt_t", header = "sys/types.h"),
    apply[posix.sys.types.gid_t](short = "gid_t", full = "posix.sys.types.gid_t", header = "sys/types.h"),
    apply[posix.sys.types.id_t](short = "id_t", full = "posix.sys.types.id_t", header = "sys/types.h"),
    apply[posix.sys.types.ino_t](short = "ino_t", full = "posix.sys.types.ino_t", header = "sys/types.h"),
    apply[posix.sys.types.key_t](short = "key_t", full = "posix.sys.types.key_t", header = "sys/types.h"),
    apply[posix.sys.types.mode_t](short = "mode_t", full = "posix.sys.types.mode_t", header = "sys/types.h"),
    apply[posix.sys.types.nlink_t](short = "nlink_t", full = "posix.sys.types.nlink_t", header = "sys/types.h"),
    apply[posix.sys.types.off_t](short = "off_t", full = "posix.sys.types.off_t", header = "sys/types.h"),
    apply[posix.sys.types.pid_t](short = "pid_t", full = "posix.sys.types.pid_t", header = "sys/types.h"),
    apply[posix.sys.types.pthread_attr_t](short = "pthread_attr_t", full = "posix.sys.types.pthread_attr_t", header = "sys/types.h"),
    apply[posix.sys.types.pthread_barrier_t](short = "pthread_barrier_t", full = "posix.sys.types.pthread_barrier_t", header = "sys/types.h"),
    apply[posix.sys.types.pthread_barrierattr_t](short = "pthread_barrierattr_t", full = "posix.sys.types.pthread_barrierattr_t", header = "sys/types.h"),
    apply[posix.sys.types.pthread_cond_t](short = "pthread_cond_t", full = "posix.sys.types.pthread_cond_t", header = "sys/types.h"),
    apply[posix.sys.types.pthread_condattr_t](short = "pthread_condattr_t", full = "posix.sys.types.pthread_condattr_t", header = "sys/types.h"),
    apply[posix.sys.types.pthread_key_t](short = "pthread_key_t", full = "posix.sys.types.pthread_key_t", header = "sys/types.h"),
    apply[posix.sys.types.pthread_mutex_t](short = "pthread_mutex_t", full = "posix.sys.types.pthread_mutex_t", header = "sys/types.h"),
    apply[posix.sys.types.pthread_mutexattr_t](short = "pthread_mutexattr_t", full = "posix.sys.types.pthread_mutexattr_t", header = "sys/types.h"),
    apply[posix.sys.types.pthread_once_t](short = "pthread_once_t", full = "posix.sys.types.pthread_once_t", header = "sys/types.h"),
    apply[posix.sys.types.pthread_rwlock_t](short = "pthread_rwlock_t", full = "posix.sys.types.pthread_rwlock_t", header = "sys/types.h"),
    apply[posix.sys.types.pthread_rwlockattr_t](short = "pthread_rwlockattr_t", full = "posix.sys.types.pthread_rwlockattr_t", header = "sys/types.h"),
    apply[posix.sys.types.pthread_spinlock_t](short = "pthread_spinlock_t", full = "posix.sys.types.pthread_spinlock_t", header = "sys/types.h"),
    apply[posix.sys.types.pthread_t](short = "pthread_t", full = "posix.sys.types.pthread_t", header = "sys/types.h"),
    apply[posix.sys.types.ssize_t](short = "ssize_t", full = "posix.sys.types.ssize_t", header = "sys/types.h"),
    apply[posix.sys.types.suseconds_t](short = "suseconds_t", full = "posix.sys.types.suseconds_t", header = "sys/types.h"),
    apply[posix.sys.types.time_t](short = "time_t", full = "posix.sys.types.time_t", header = "sys/types.h"),
    apply[posix.sys.types.uid_t](short = "uid_t", full = "posix.sys.types.uid_t", header = "sys/types.h"),
    apply[posix.sys.statvfs.fsblkcnt_t](short = "fsblkcnt_t", full = "posix.sys.statvfs.fsblkcnt_t", header = "sys/statvfs.h"),
    apply[posix.sys.statvfs.fsfilcnt_t](short = "fsfilcnt_t", full = "posix.sys.statvfs.fsfilcnt_t", header = "sys/statvfs.h"),
    apply[posix.sys.statvfs.statvfs](short = "statvfs", full = "posix.sys.statvfs.statvfs", header = "sys/statvfs.h"),
    apply[posix.sys.socket.socklen_t](short = "socklen_t", full = "posix.sys.socket.socklen_t", header = "sys/socket.h"),
    apply[posix.sys.socket.sa_family_t](short = "sa_family_t", full = "posix.sys.socket.sa_family_t", header = "sys/socket.h"),
    apply[posix.sys.socket.sockaddr](short = "sockaddr", full = "posix.sys.socket.sockaddr", header = "sys/socket.h"),
    apply[posix.sys.socket.sockaddr_storage](short = "sockaddr_storage", full = "posix.sys.socket.sockaddr_storage", header = "sys/socket.h"),
    apply[posix.sys.socket.msghdr](short = "msghdr", full = "posix.sys.socket.msghdr", header = "sys/socket.h"),
    apply[posix.sys.socket.cmsghdr](short = "cmsghdr", full = "posix.sys.socket.cmsghdr", header = "sys/socket.h"),
    apply[posix.sys.socket.linger](short = "linger", full = "posix.sys.socket.linger", header = "sys/socket.h"),
    apply[posix.glob.glob_t](short = "glob_t", full = "posix.glob.glob_t", header = "glob.h"),
    apply[posix.glob.unixGlob_t](short = "unixGlob_t", full = "posix.glob.unixGlob_t", header = "glob.h"),
    apply[posix.fcntl.flock](short = "flock", full = "posix.fcntl.flock", header = "fcntl.h"),
    apply[posix.unistd.off_t](short = "off_t", full = "posix.unistd.off_t", header = "unistd.h"),
    apply[posix.signal.sig_atomic_t](short = "sig_atomic_t", full = "posix.signal.sig_atomic_t", header = "signal.h"),
    apply[posix.signal.sigset_t](short = "sigset_t", full = "posix.signal.sigset_t", header = "signal.h"),
    apply[posix.signal.sigevent](short = "sigevent", full = "posix.signal.sigevent", header = "signal.h"),
    apply[posix.signal.sigaction](short = "sigaction", full = "posix.signal.sigaction", header = "signal.h"),
    apply[posix.signal.mcontext_t](short = "mcontext_t", full = "posix.signal.mcontext_t", header = "signal.h"),
    apply[posix.signal.ucontext_t](short = "ucontext_t", full = "posix.signal.ucontext_t", header = "signal.h"),
    apply[posix.signal.stack_t](short = "stack_t", full = "posix.signal.stack_t", header = "signal.h"),
    apply[posix.signal.siginfo_t](short = "siginfo_t", full = "posix.signal.siginfo_t", header = "signal.h"),
    apply[posix.dirent.dirent](short = "dirent", full = "posix.dirent.dirent", header = "dirent.h"),
    apply[posix.utime.utimbuf](short = "utimbuf", full = "posix.utime.utimbuf", header = "utime.h"),
    apply[libc.locale.lconv](short = "lconv", full = "libc.locale.lconv", header = "locale.h"),
    apply[libc.inttypes.imaxdiv_t](short = "imaxdiv_t", full = "libc.inttypes.imaxdiv_t", header = "inttypes.h"),
    apply[libc.stddef.ptrdiff_t](short = "ptrdiff_t", full = "libc.stddef.ptrdiff_t", header = "stddef.h"),
    apply[libc.stddef.wchar_t](short = "wchar_t", full = "libc.stddef.wchar_t", header = "stddef.h"),
    apply[libc.stddef.size_t](short = "size_t", full = "libc.stddef.size_t", header = "stddef.h"),
    apply[libc.fenv.fexcept_t](short = "fexcept_t", full = "libc.fenv.fexcept_t", header = "fenv.h"),
    apply[libc.fenv.fenv_t](short = "fenv_t", full = "libc.fenv.fenv_t", header = "fenv.h"),
    apply[libc.complex.CFloatComplex](short = "CFloatComplex", full = "libc.complex.CFloatComplex", header = "complex.h"),
    apply[libc.complex.CDoubleComplex](short = "CDoubleComplex", full = "libc.complex.CDoubleComplex", header = "complex.h"),
    apply[libc.stdio.FILE](short = "FILE", full = "libc.stdio.FILE", header = "stdio.h"),
    apply[libc.stdio.fpos_t](short = "fpos_t", full = "libc.stdio.fpos_t", header = "stdio.h"),
    apply[libc.stdint.intmax_t](short = "intmax_t", full = "libc.stdint.intmax_t", header = "stdint.h"),
    apply[libc.stdint.uintmax_t](short = "uintmax_t", full = "libc.stdint.uintmax_t", header = "stdint.h"),
    // GENERATEDCODE: END
    // format: on
    apply[CVarArgList](
      short = "va_list",
      full = "unsafe.CVarArgList",
      header = "stdarg.h"
    ),
    apply[UByte]("uint8_t", _unsigned("UByte")),
    apply[UShort]("uint16_t", _unsigned("UShort")),
    apply[UInt]("uint32_t", _unsigned("UInt")),
    apply[ULong]("uint64_t", _unsigned("ULong")),
    apply[CChar]("int8_t", _unsafe("CChar")),
    apply[Short]("int16_t", _scala("Short")),
    apply[CInt]("int32_t", _unsafe("CInt")),
    apply[Long]("int64_t", _scala("Long"))
  )
end BuiltinType
