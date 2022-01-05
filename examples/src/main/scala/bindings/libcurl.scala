package libcurl

import scala.scalanative.unsafe.*
import scala.scalanative.unsigned.*
import scalanative.libc.*

object predef:  
  abstract class CEnum[T](using eq: T =:= Int):
    given Tag[T] = Tag.Int.asInstanceOf[Tag[T]]
    extension (t: T) def int: CInt = eq.apply(t)
  
  abstract class CEnumU[T](using eq: T =:= UInt):
    given Tag[T] = Tag.UInt.asInstanceOf[Tag[T]]
    extension (t: T)
     def int: CInt = eq.apply(t).toInt
     def uint: CUnsignedInt = eq.apply(t)
      
object types:
  import predef.*
  opaque type CURLFORMcode = CUnsignedInt
  object CURLFORMcode extends CEnumU[CURLFORMcode]:
    inline def define(inline a: Long): CURLFORMcode = a.toUInt
    val CURL_FORMADD_OK = define(0)
    val CURL_FORMADD_MEMORY = define(1)
    val CURL_FORMADD_OPTION_TWICE = define(2)
    val CURL_FORMADD_NULL = define(3)
    val CURL_FORMADD_UNKNOWN_OPTION = define(4)
    val CURL_FORMADD_INCOMPLETE = define(5)
    val CURL_FORMADD_ILLEGAL_ARRAY = define(6)
    val CURL_FORMADD_DISABLED = define(7)
    val CURL_FORMADD_LAST = define(8)

  opaque type CURLINFO = CUnsignedInt
  object CURLINFO extends CEnumU[CURLINFO]:
    inline def define(inline a: Long): CURLINFO = a.toUInt
    val CURLINFO_NONE = define(0)
    val CURLINFO_EFFECTIVE_URL = define(1048577)
    val CURLINFO_RESPONSE_CODE = define(2097154)
    val CURLINFO_TOTAL_TIME = define(3145731)
    val CURLINFO_NAMELOOKUP_TIME = define(3145732)
    val CURLINFO_CONNECT_TIME = define(3145733)
    val CURLINFO_PRETRANSFER_TIME = define(3145734)
    val CURLINFO_SIZE_UPLOAD = define(3145735)
    val CURLINFO_SIZE_UPLOAD_T = define(6291463)
    val CURLINFO_SIZE_DOWNLOAD = define(3145736)
    val CURLINFO_SIZE_DOWNLOAD_T = define(6291464)
    val CURLINFO_SPEED_DOWNLOAD = define(3145737)
    val CURLINFO_SPEED_DOWNLOAD_T = define(6291465)
    val CURLINFO_SPEED_UPLOAD = define(3145738)
    val CURLINFO_SPEED_UPLOAD_T = define(6291466)
    val CURLINFO_HEADER_SIZE = define(2097163)
    val CURLINFO_REQUEST_SIZE = define(2097164)
    val CURLINFO_SSL_VERIFYRESULT = define(2097165)
    val CURLINFO_FILETIME = define(2097166)
    val CURLINFO_FILETIME_T = define(6291470)
    val CURLINFO_CONTENT_LENGTH_DOWNLOAD = define(3145743)
    val CURLINFO_CONTENT_LENGTH_DOWNLOAD_T = define(6291471)
    val CURLINFO_CONTENT_LENGTH_UPLOAD = define(3145744)
    val CURLINFO_CONTENT_LENGTH_UPLOAD_T = define(6291472)
    val CURLINFO_STARTTRANSFER_TIME = define(3145745)
    val CURLINFO_CONTENT_TYPE = define(1048594)
    val CURLINFO_REDIRECT_TIME = define(3145747)
    val CURLINFO_REDIRECT_COUNT = define(2097172)
    val CURLINFO_PRIVATE = define(1048597)
    val CURLINFO_HTTP_CONNECTCODE = define(2097174)
    val CURLINFO_HTTPAUTH_AVAIL = define(2097175)
    val CURLINFO_PROXYAUTH_AVAIL = define(2097176)
    val CURLINFO_OS_ERRNO = define(2097177)
    val CURLINFO_NUM_CONNECTS = define(2097178)
    val CURLINFO_SSL_ENGINES = define(4194331)
    val CURLINFO_COOKIELIST = define(4194332)
    val CURLINFO_LASTSOCKET = define(2097181)
    val CURLINFO_FTP_ENTRY_PATH = define(1048606)
    val CURLINFO_REDIRECT_URL = define(1048607)
    val CURLINFO_PRIMARY_IP = define(1048608)
    val CURLINFO_APPCONNECT_TIME = define(3145761)
    val CURLINFO_CERTINFO = define(4194338)
    val CURLINFO_CONDITION_UNMET = define(2097187)
    val CURLINFO_RTSP_SESSION_ID = define(1048612)
    val CURLINFO_RTSP_CLIENT_CSEQ = define(2097189)
    val CURLINFO_RTSP_SERVER_CSEQ = define(2097190)
    val CURLINFO_RTSP_CSEQ_RECV = define(2097191)
    val CURLINFO_PRIMARY_PORT = define(2097192)
    val CURLINFO_LOCAL_IP = define(1048617)
    val CURLINFO_LOCAL_PORT = define(2097194)
    val CURLINFO_TLS_SESSION = define(4194347)
    val CURLINFO_ACTIVESOCKET = define(5242924)
    val CURLINFO_TLS_SSL_PTR = define(4194349)
    val CURLINFO_HTTP_VERSION = define(2097198)
    val CURLINFO_PROXY_SSL_VERIFYRESULT = define(2097199)
    val CURLINFO_PROTOCOL = define(2097200)
    val CURLINFO_SCHEME = define(1048625)
    val CURLINFO_TOTAL_TIME_T = define(6291506)
    val CURLINFO_NAMELOOKUP_TIME_T = define(6291507)
    val CURLINFO_CONNECT_TIME_T = define(6291508)
    val CURLINFO_PRETRANSFER_TIME_T = define(6291509)
    val CURLINFO_STARTTRANSFER_TIME_T = define(6291510)
    val CURLINFO_REDIRECT_TIME_T = define(6291511)
    val CURLINFO_APPCONNECT_TIME_T = define(6291512)
    val CURLINFO_RETRY_AFTER = define(6291513)
    val CURLINFO_EFFECTIVE_METHOD = define(1048634)
    val CURLINFO_PROXY_ERROR = define(2097211)
    val CURLINFO_REFERER = define(1048636)
    val CURLINFO_LASTONE = define(60)

  opaque type CURLMSG = CUnsignedInt
  object CURLMSG extends CEnumU[CURLMSG]:
    inline def define(inline a: Long): CURLMSG = a.toUInt
    val CURLMSG_NONE = define(0)
    val CURLMSG_DONE = define(1)
    val CURLMSG_LAST = define(2)

  opaque type CURLMcode = CInt
  object CURLMcode extends CEnum[CURLMcode]:
    inline def define(inline a: CInt): CURLMcode = a
    val CURLM_CALL_MULTI_PERFORM = define(-1)
    val CURLM_OK = define(0)
    val CURLM_BAD_HANDLE = define(1)
    val CURLM_BAD_EASY_HANDLE = define(2)
    val CURLM_OUT_OF_MEMORY = define(3)
    val CURLM_INTERNAL_ERROR = define(4)
    val CURLM_BAD_SOCKET = define(5)
    val CURLM_UNKNOWN_OPTION = define(6)
    val CURLM_ADDED_ALREADY = define(7)
    val CURLM_RECURSIVE_API_CALL = define(8)
    val CURLM_WAKEUP_FAILURE = define(9)
    val CURLM_BAD_FUNCTION_ARGUMENT = define(10)
    val CURLM_LAST = define(11)

  opaque type CURLMoption = CUnsignedInt
  object CURLMoption extends CEnumU[CURLMoption]:
    inline def define(inline a: Long): CURLMoption = a.toUInt
    val CURLMOPT_SOCKETFUNCTION = define(20001)
    val CURLMOPT_SOCKETDATA = define(10002)
    val CURLMOPT_PIPELINING = define(3)
    val CURLMOPT_TIMERFUNCTION = define(20004)
    val CURLMOPT_TIMERDATA = define(10005)
    val CURLMOPT_MAXCONNECTS = define(6)
    val CURLMOPT_MAX_HOST_CONNECTIONS = define(7)
    val CURLMOPT_MAX_PIPELINE_LENGTH = define(8)
    val CURLMOPT_CONTENT_LENGTH_PENALTY_SIZE = define(30009)
    val CURLMOPT_CHUNK_LENGTH_PENALTY_SIZE = define(30010)
    val CURLMOPT_PIPELINING_SITE_BL = define(10011)
    val CURLMOPT_PIPELINING_SERVER_BL = define(10012)
    val CURLMOPT_MAX_TOTAL_CONNECTIONS = define(13)
    val CURLMOPT_PUSHFUNCTION = define(20014)
    val CURLMOPT_PUSHDATA = define(10015)
    val CURLMOPT_MAX_CONCURRENT_STREAMS = define(16)
    val CURLMOPT_LASTENTRY = define(17)

  opaque type CURLSHcode = CUnsignedInt
  object CURLSHcode extends CEnumU[CURLSHcode]:
    inline def define(inline a: Long): CURLSHcode = a.toUInt
    val CURLSHE_OK = define(0)
    val CURLSHE_BAD_OPTION = define(1)
    val CURLSHE_IN_USE = define(2)
    val CURLSHE_INVALID = define(3)
    val CURLSHE_NOMEM = define(4)
    val CURLSHE_NOT_BUILT_IN = define(5)
    val CURLSHE_LAST = define(6)

  opaque type CURLSHoption = CUnsignedInt
  object CURLSHoption extends CEnumU[CURLSHoption]:
    inline def define(inline a: Long): CURLSHoption = a.toUInt
    val CURLSHOPT_NONE = define(0)
    val CURLSHOPT_SHARE = define(1)
    val CURLSHOPT_UNSHARE = define(2)
    val CURLSHOPT_LOCKFUNC = define(3)
    val CURLSHOPT_UNLOCKFUNC = define(4)
    val CURLSHOPT_USERDATA = define(5)
    val CURLSHOPT_LAST = define(6)

  opaque type CURLSTScode = CUnsignedInt
  object CURLSTScode extends CEnumU[CURLSTScode]:
    inline def define(inline a: Long): CURLSTScode = a.toUInt
    val CURLSTS_OK = define(0)
    val CURLSTS_DONE = define(1)
    val CURLSTS_FAIL = define(2)

  opaque type CURLUPart = CUnsignedInt
  object CURLUPart extends CEnumU[CURLUPart]:
    inline def define(inline a: Long): CURLUPart = a.toUInt
    val CURLUPART_URL = define(0)
    val CURLUPART_SCHEME = define(1)
    val CURLUPART_USER = define(2)
    val CURLUPART_PASSWORD = define(3)
    val CURLUPART_OPTIONS = define(4)
    val CURLUPART_HOST = define(5)
    val CURLUPART_PORT = define(6)
    val CURLUPART_PATH = define(7)
    val CURLUPART_QUERY = define(8)
    val CURLUPART_FRAGMENT = define(9)
    val CURLUPART_ZONEID = define(10)

  opaque type CURLUcode = CUnsignedInt
  object CURLUcode extends CEnumU[CURLUcode]:
    inline def define(inline a: Long): CURLUcode = a.toUInt
    val CURLUE_OK = define(0)
    val CURLUE_BAD_HANDLE = define(1)
    val CURLUE_BAD_PARTPOINTER = define(2)
    val CURLUE_MALFORMED_INPUT = define(3)
    val CURLUE_BAD_PORT_NUMBER = define(4)
    val CURLUE_UNSUPPORTED_SCHEME = define(5)
    val CURLUE_URLDECODE = define(6)
    val CURLUE_OUT_OF_MEMORY = define(7)
    val CURLUE_USER_NOT_ALLOWED = define(8)
    val CURLUE_UNKNOWN_PART = define(9)
    val CURLUE_NO_SCHEME = define(10)
    val CURLUE_NO_USER = define(11)
    val CURLUE_NO_PASSWORD = define(12)
    val CURLUE_NO_OPTIONS = define(13)
    val CURLUE_NO_HOST = define(14)
    val CURLUE_NO_PORT = define(15)
    val CURLUE_NO_QUERY = define(16)
    val CURLUE_NO_FRAGMENT = define(17)

  opaque type CURL_NETRC_OPTION = CUnsignedInt
  object CURL_NETRC_OPTION extends CEnumU[CURL_NETRC_OPTION]:
    inline def define(inline a: Long): CURL_NETRC_OPTION = a.toUInt
    val CURL_NETRC_IGNORED = define(0)
    val CURL_NETRC_OPTIONAL = define(1)
    val CURL_NETRC_REQUIRED = define(2)
    val CURL_NETRC_LAST = define(3)

  opaque type CURL_TLSAUTH = CUnsignedInt
  object CURL_TLSAUTH extends CEnumU[CURL_TLSAUTH]:
    inline def define(inline a: Long): CURL_TLSAUTH = a.toUInt
    val CURL_TLSAUTH_NONE = define(0)
    val CURL_TLSAUTH_SRP = define(1)
    val CURL_TLSAUTH_LAST = define(2)

  opaque type CURLcode = CUnsignedInt
  object CURLcode extends CEnumU[CURLcode]:
    inline def define(inline a: Long): CURLcode = a.toUInt
    val CURLE_OK = define(0)
    val CURLE_UNSUPPORTED_PROTOCOL = define(1)
    val CURLE_FAILED_INIT = define(2)
    val CURLE_URL_MALFORMAT = define(3)
    val CURLE_NOT_BUILT_IN = define(4)
    val CURLE_COULDNT_RESOLVE_PROXY = define(5)
    val CURLE_COULDNT_RESOLVE_HOST = define(6)
    val CURLE_COULDNT_CONNECT = define(7)
    val CURLE_WEIRD_SERVER_REPLY = define(8)
    val CURLE_REMOTE_ACCESS_DENIED = define(9)
    val CURLE_FTP_ACCEPT_FAILED = define(10)
    val CURLE_FTP_WEIRD_PASS_REPLY = define(11)
    val CURLE_FTP_ACCEPT_TIMEOUT = define(12)
    val CURLE_FTP_WEIRD_PASV_REPLY = define(13)
    val CURLE_FTP_WEIRD_227_FORMAT = define(14)
    val CURLE_FTP_CANT_GET_HOST = define(15)
    val CURLE_HTTP2 = define(16)
    val CURLE_FTP_COULDNT_SET_TYPE = define(17)
    val CURLE_PARTIAL_FILE = define(18)
    val CURLE_FTP_COULDNT_RETR_FILE = define(19)
    val CURLE_OBSOLETE20 = define(20)
    val CURLE_QUOTE_ERROR = define(21)
    val CURLE_HTTP_RETURNED_ERROR = define(22)
    val CURLE_WRITE_ERROR = define(23)
    val CURLE_OBSOLETE24 = define(24)
    val CURLE_UPLOAD_FAILED = define(25)
    val CURLE_READ_ERROR = define(26)
    val CURLE_OUT_OF_MEMORY = define(27)
    val CURLE_OPERATION_TIMEDOUT = define(28)
    val CURLE_OBSOLETE29 = define(29)
    val CURLE_FTP_PORT_FAILED = define(30)
    val CURLE_FTP_COULDNT_USE_REST = define(31)
    val CURLE_OBSOLETE32 = define(32)
    val CURLE_RANGE_ERROR = define(33)
    val CURLE_HTTP_POST_ERROR = define(34)
    val CURLE_SSL_CONNECT_ERROR = define(35)
    val CURLE_BAD_DOWNLOAD_RESUME = define(36)
    val CURLE_FILE_COULDNT_READ_FILE = define(37)
    val CURLE_LDAP_CANNOT_BIND = define(38)
    val CURLE_LDAP_SEARCH_FAILED = define(39)
    val CURLE_OBSOLETE40 = define(40)
    val CURLE_FUNCTION_NOT_FOUND = define(41)
    val CURLE_ABORTED_BY_CALLBACK = define(42)
    val CURLE_BAD_FUNCTION_ARGUMENT = define(43)
    val CURLE_OBSOLETE44 = define(44)
    val CURLE_INTERFACE_FAILED = define(45)
    val CURLE_OBSOLETE46 = define(46)
    val CURLE_TOO_MANY_REDIRECTS = define(47)
    val CURLE_UNKNOWN_OPTION = define(48)
    val CURLE_SETOPT_OPTION_SYNTAX = define(49)
    val CURLE_OBSOLETE50 = define(50)
    val CURLE_OBSOLETE51 = define(51)
    val CURLE_GOT_NOTHING = define(52)
    val CURLE_SSL_ENGINE_NOTFOUND = define(53)
    val CURLE_SSL_ENGINE_SETFAILED = define(54)
    val CURLE_SEND_ERROR = define(55)
    val CURLE_RECV_ERROR = define(56)
    val CURLE_OBSOLETE57 = define(57)
    val CURLE_SSL_CERTPROBLEM = define(58)
    val CURLE_SSL_CIPHER = define(59)
    val CURLE_PEER_FAILED_VERIFICATION = define(60)
    val CURLE_BAD_CONTENT_ENCODING = define(61)
    val CURLE_LDAP_INVALID_URL = define(62)
    val CURLE_FILESIZE_EXCEEDED = define(63)
    val CURLE_USE_SSL_FAILED = define(64)
    val CURLE_SEND_FAIL_REWIND = define(65)
    val CURLE_SSL_ENGINE_INITFAILED = define(66)
    val CURLE_LOGIN_DENIED = define(67)
    val CURLE_TFTP_NOTFOUND = define(68)
    val CURLE_TFTP_PERM = define(69)
    val CURLE_REMOTE_DISK_FULL = define(70)
    val CURLE_TFTP_ILLEGAL = define(71)
    val CURLE_TFTP_UNKNOWNID = define(72)
    val CURLE_REMOTE_FILE_EXISTS = define(73)
    val CURLE_TFTP_NOSUCHUSER = define(74)
    val CURLE_CONV_FAILED = define(75)
    val CURLE_CONV_REQD = define(76)
    val CURLE_SSL_CACERT_BADFILE = define(77)
    val CURLE_REMOTE_FILE_NOT_FOUND = define(78)
    val CURLE_SSH = define(79)
    val CURLE_SSL_SHUTDOWN_FAILED = define(80)
    val CURLE_AGAIN = define(81)
    val CURLE_SSL_CRL_BADFILE = define(82)
    val CURLE_SSL_ISSUER_ERROR = define(83)
    val CURLE_FTP_PRET_FAILED = define(84)
    val CURLE_RTSP_CSEQ_ERROR = define(85)
    val CURLE_RTSP_SESSION_ERROR = define(86)
    val CURLE_FTP_BAD_FILE_LIST = define(87)
    val CURLE_CHUNK_FAILED = define(88)
    val CURLE_NO_CONNECTION_AVAILABLE = define(89)
    val CURLE_SSL_PINNEDPUBKEYNOTMATCH = define(90)
    val CURLE_SSL_INVALIDCERTSTATUS = define(91)
    val CURLE_HTTP2_STREAM = define(92)
    val CURLE_RECURSIVE_API_CALL = define(93)
    val CURLE_AUTH_ERROR = define(94)
    val CURLE_HTTP3 = define(95)
    val CURLE_QUIC_CONNECT_ERROR = define(96)
    val CURLE_PROXY = define(97)
    val CURLE_SSL_CLIENTCERT = define(98)
    val CURL_LAST = define(99)

  opaque type CURLformoption = CUnsignedInt
  object CURLformoption extends CEnumU[CURLformoption]:
    inline def define(inline a: Long): CURLformoption = a.toUInt
    val CURLFORM_NOTHING = define(0)
    val CURLFORM_COPYNAME = define(1)
    val CURLFORM_PTRNAME = define(2)
    val CURLFORM_NAMELENGTH = define(3)
    val CURLFORM_COPYCONTENTS = define(4)
    val CURLFORM_PTRCONTENTS = define(5)
    val CURLFORM_CONTENTSLENGTH = define(6)
    val CURLFORM_FILECONTENT = define(7)
    val CURLFORM_ARRAY = define(8)
    val CURLFORM_OBSOLETE = define(9)
    val CURLFORM_FILE = define(10)
    val CURLFORM_BUFFER = define(11)
    val CURLFORM_BUFFERPTR = define(12)
    val CURLFORM_BUFFERLENGTH = define(13)
    val CURLFORM_CONTENTTYPE = define(14)
    val CURLFORM_CONTENTHEADER = define(15)
    val CURLFORM_FILENAME = define(16)
    val CURLFORM_END = define(17)
    val CURLFORM_OBSOLETE2 = define(18)
    val CURLFORM_STREAM = define(19)
    val CURLFORM_CONTENTLEN = define(20)
    val CURLFORM_LASTENTRY = define(21)

  opaque type CURLoption = CUnsignedInt
  object CURLoption extends CEnumU[CURLoption]:
    inline def define(inline a: Long): CURLoption = a.toUInt
    val CURLOPT_WRITEDATA = define(10001)
    val CURLOPT_URL = define(10002)
    val CURLOPT_PORT = define(3)
    val CURLOPT_PROXY = define(10004)
    val CURLOPT_USERPWD = define(10005)
    val CURLOPT_PROXYUSERPWD = define(10006)
    val CURLOPT_RANGE = define(10007)
    val CURLOPT_READDATA = define(10009)
    val CURLOPT_ERRORBUFFER = define(10010)
    val CURLOPT_WRITEFUNCTION = define(20011)
    val CURLOPT_READFUNCTION = define(20012)
    val CURLOPT_TIMEOUT = define(13)
    val CURLOPT_INFILESIZE = define(14)
    val CURLOPT_POSTFIELDS = define(10015)
    val CURLOPT_REFERER = define(10016)
    val CURLOPT_FTPPORT = define(10017)
    val CURLOPT_USERAGENT = define(10018)
    val CURLOPT_LOW_SPEED_LIMIT = define(19)
    val CURLOPT_LOW_SPEED_TIME = define(20)
    val CURLOPT_RESUME_FROM = define(21)
    val CURLOPT_COOKIE = define(10022)
    val CURLOPT_HTTPHEADER = define(10023)
    val CURLOPT_HTTPPOST = define(10024)
    val CURLOPT_SSLCERT = define(10025)
    val CURLOPT_KEYPASSWD = define(10026)
    val CURLOPT_CRLF = define(27)
    val CURLOPT_QUOTE = define(10028)
    val CURLOPT_HEADERDATA = define(10029)
    val CURLOPT_COOKIEFILE = define(10031)
    val CURLOPT_SSLVERSION = define(32)
    val CURLOPT_TIMECONDITION = define(33)
    val CURLOPT_TIMEVALUE = define(34)
    val CURLOPT_CUSTOMREQUEST = define(10036)
    val CURLOPT_STDERR = define(10037)
    val CURLOPT_POSTQUOTE = define(10039)
    val CURLOPT_OBSOLETE40 = define(10040)
    val CURLOPT_VERBOSE = define(41)
    val CURLOPT_HEADER = define(42)
    val CURLOPT_NOPROGRESS = define(43)
    val CURLOPT_NOBODY = define(44)
    val CURLOPT_FAILONERROR = define(45)
    val CURLOPT_UPLOAD = define(46)
    val CURLOPT_POST = define(47)
    val CURLOPT_DIRLISTONLY = define(48)
    val CURLOPT_APPEND = define(50)
    val CURLOPT_NETRC = define(51)
    val CURLOPT_FOLLOWLOCATION = define(52)
    val CURLOPT_TRANSFERTEXT = define(53)
    val CURLOPT_PUT = define(54)
    val CURLOPT_PROGRESSFUNCTION = define(20056)
    val CURLOPT_XFERINFODATA = define(10057)
    val CURLOPT_AUTOREFERER = define(58)
    val CURLOPT_PROXYPORT = define(59)
    val CURLOPT_POSTFIELDSIZE = define(60)
    val CURLOPT_HTTPPROXYTUNNEL = define(61)
    val CURLOPT_INTERFACE = define(10062)
    val CURLOPT_KRBLEVEL = define(10063)
    val CURLOPT_SSL_VERIFYPEER = define(64)
    val CURLOPT_CAINFO = define(10065)
    val CURLOPT_MAXREDIRS = define(68)
    val CURLOPT_FILETIME = define(69)
    val CURLOPT_TELNETOPTIONS = define(10070)
    val CURLOPT_MAXCONNECTS = define(71)
    val CURLOPT_OBSOLETE72 = define(72)
    val CURLOPT_FRESH_CONNECT = define(74)
    val CURLOPT_FORBID_REUSE = define(75)
    val CURLOPT_RANDOM_FILE = define(10076)
    val CURLOPT_EGDSOCKET = define(10077)
    val CURLOPT_CONNECTTIMEOUT = define(78)
    val CURLOPT_HEADERFUNCTION = define(20079)
    val CURLOPT_HTTPGET = define(80)
    val CURLOPT_SSL_VERIFYHOST = define(81)
    val CURLOPT_COOKIEJAR = define(10082)
    val CURLOPT_SSL_CIPHER_LIST = define(10083)
    val CURLOPT_HTTP_VERSION = define(84)
    val CURLOPT_FTP_USE_EPSV = define(85)
    val CURLOPT_SSLCERTTYPE = define(10086)
    val CURLOPT_SSLKEY = define(10087)
    val CURLOPT_SSLKEYTYPE = define(10088)
    val CURLOPT_SSLENGINE = define(10089)
    val CURLOPT_SSLENGINE_DEFAULT = define(90)
    val CURLOPT_DNS_USE_GLOBAL_CACHE = define(91)
    val CURLOPT_DNS_CACHE_TIMEOUT = define(92)
    val CURLOPT_PREQUOTE = define(10093)
    val CURLOPT_DEBUGFUNCTION = define(20094)
    val CURLOPT_DEBUGDATA = define(10095)
    val CURLOPT_COOKIESESSION = define(96)
    val CURLOPT_CAPATH = define(10097)
    val CURLOPT_BUFFERSIZE = define(98)
    val CURLOPT_NOSIGNAL = define(99)
    val CURLOPT_SHARE = define(10100)
    val CURLOPT_PROXYTYPE = define(101)
    val CURLOPT_ACCEPT_ENCODING = define(10102)
    val CURLOPT_PRIVATE = define(10103)
    val CURLOPT_HTTP200ALIASES = define(10104)
    val CURLOPT_UNRESTRICTED_AUTH = define(105)
    val CURLOPT_FTP_USE_EPRT = define(106)
    val CURLOPT_HTTPAUTH = define(107)
    val CURLOPT_SSL_CTX_FUNCTION = define(20108)
    val CURLOPT_SSL_CTX_DATA = define(10109)
    val CURLOPT_FTP_CREATE_MISSING_DIRS = define(110)
    val CURLOPT_PROXYAUTH = define(111)
    val CURLOPT_FTP_RESPONSE_TIMEOUT = define(112)
    val CURLOPT_IPRESOLVE = define(113)
    val CURLOPT_MAXFILESIZE = define(114)
    val CURLOPT_INFILESIZE_LARGE = define(30115)
    val CURLOPT_RESUME_FROM_LARGE = define(30116)
    val CURLOPT_MAXFILESIZE_LARGE = define(30117)
    val CURLOPT_NETRC_FILE = define(10118)
    val CURLOPT_USE_SSL = define(119)
    val CURLOPT_POSTFIELDSIZE_LARGE = define(30120)
    val CURLOPT_TCP_NODELAY = define(121)
    val CURLOPT_FTPSSLAUTH = define(129)
    val CURLOPT_IOCTLFUNCTION = define(20130)
    val CURLOPT_IOCTLDATA = define(10131)
    val CURLOPT_FTP_ACCOUNT = define(10134)
    val CURLOPT_COOKIELIST = define(10135)
    val CURLOPT_IGNORE_CONTENT_LENGTH = define(136)
    val CURLOPT_FTP_SKIP_PASV_IP = define(137)
    val CURLOPT_FTP_FILEMETHOD = define(138)
    val CURLOPT_LOCALPORT = define(139)
    val CURLOPT_LOCALPORTRANGE = define(140)
    val CURLOPT_CONNECT_ONLY = define(141)
    val CURLOPT_CONV_FROM_NETWORK_FUNCTION = define(20142)
    val CURLOPT_CONV_TO_NETWORK_FUNCTION = define(20143)
    val CURLOPT_CONV_FROM_UTF8_FUNCTION = define(20144)
    val CURLOPT_MAX_SEND_SPEED_LARGE = define(30145)
    val CURLOPT_MAX_RECV_SPEED_LARGE = define(30146)
    val CURLOPT_FTP_ALTERNATIVE_TO_USER = define(10147)
    val CURLOPT_SOCKOPTFUNCTION = define(20148)
    val CURLOPT_SOCKOPTDATA = define(10149)
    val CURLOPT_SSL_SESSIONID_CACHE = define(150)
    val CURLOPT_SSH_AUTH_TYPES = define(151)
    val CURLOPT_SSH_PUBLIC_KEYFILE = define(10152)
    val CURLOPT_SSH_PRIVATE_KEYFILE = define(10153)
    val CURLOPT_FTP_SSL_CCC = define(154)
    val CURLOPT_TIMEOUT_MS = define(155)
    val CURLOPT_CONNECTTIMEOUT_MS = define(156)
    val CURLOPT_HTTP_TRANSFER_DECODING = define(157)
    val CURLOPT_HTTP_CONTENT_DECODING = define(158)
    val CURLOPT_NEW_FILE_PERMS = define(159)
    val CURLOPT_NEW_DIRECTORY_PERMS = define(160)
    val CURLOPT_POSTREDIR = define(161)
    val CURLOPT_SSH_HOST_PUBLIC_KEY_MD5 = define(10162)
    val CURLOPT_OPENSOCKETFUNCTION = define(20163)
    val CURLOPT_OPENSOCKETDATA = define(10164)
    val CURLOPT_COPYPOSTFIELDS = define(10165)
    val CURLOPT_PROXY_TRANSFER_MODE = define(166)
    val CURLOPT_SEEKFUNCTION = define(20167)
    val CURLOPT_SEEKDATA = define(10168)
    val CURLOPT_CRLFILE = define(10169)
    val CURLOPT_ISSUERCERT = define(10170)
    val CURLOPT_ADDRESS_SCOPE = define(171)
    val CURLOPT_CERTINFO = define(172)
    val CURLOPT_USERNAME = define(10173)
    val CURLOPT_PASSWORD = define(10174)
    val CURLOPT_PROXYUSERNAME = define(10175)
    val CURLOPT_PROXYPASSWORD = define(10176)
    val CURLOPT_NOPROXY = define(10177)
    val CURLOPT_TFTP_BLKSIZE = define(178)
    val CURLOPT_SOCKS5_GSSAPI_SERVICE = define(10179)
    val CURLOPT_SOCKS5_GSSAPI_NEC = define(180)
    val CURLOPT_PROTOCOLS = define(181)
    val CURLOPT_REDIR_PROTOCOLS = define(182)
    val CURLOPT_SSH_KNOWNHOSTS = define(10183)
    val CURLOPT_SSH_KEYFUNCTION = define(20184)
    val CURLOPT_SSH_KEYDATA = define(10185)
    val CURLOPT_MAIL_FROM = define(10186)
    val CURLOPT_MAIL_RCPT = define(10187)
    val CURLOPT_FTP_USE_PRET = define(188)
    val CURLOPT_RTSP_REQUEST = define(189)
    val CURLOPT_RTSP_SESSION_ID = define(10190)
    val CURLOPT_RTSP_STREAM_URI = define(10191)
    val CURLOPT_RTSP_TRANSPORT = define(10192)
    val CURLOPT_RTSP_CLIENT_CSEQ = define(193)
    val CURLOPT_RTSP_SERVER_CSEQ = define(194)
    val CURLOPT_INTERLEAVEDATA = define(10195)
    val CURLOPT_INTERLEAVEFUNCTION = define(20196)
    val CURLOPT_WILDCARDMATCH = define(197)
    val CURLOPT_CHUNK_BGN_FUNCTION = define(20198)
    val CURLOPT_CHUNK_END_FUNCTION = define(20199)
    val CURLOPT_FNMATCH_FUNCTION = define(20200)
    val CURLOPT_CHUNK_DATA = define(10201)
    val CURLOPT_FNMATCH_DATA = define(10202)
    val CURLOPT_RESOLVE = define(10203)
    val CURLOPT_TLSAUTH_USERNAME = define(10204)
    val CURLOPT_TLSAUTH_PASSWORD = define(10205)
    val CURLOPT_TLSAUTH_TYPE = define(10206)
    val CURLOPT_TRANSFER_ENCODING = define(207)
    val CURLOPT_CLOSESOCKETFUNCTION = define(20208)
    val CURLOPT_CLOSESOCKETDATA = define(10209)
    val CURLOPT_GSSAPI_DELEGATION = define(210)
    val CURLOPT_DNS_SERVERS = define(10211)
    val CURLOPT_ACCEPTTIMEOUT_MS = define(212)
    val CURLOPT_TCP_KEEPALIVE = define(213)
    val CURLOPT_TCP_KEEPIDLE = define(214)
    val CURLOPT_TCP_KEEPINTVL = define(215)
    val CURLOPT_SSL_OPTIONS = define(216)
    val CURLOPT_MAIL_AUTH = define(10217)
    val CURLOPT_SASL_IR = define(218)
    val CURLOPT_XFERINFOFUNCTION = define(20219)
    val CURLOPT_XOAUTH2_BEARER = define(10220)
    val CURLOPT_DNS_INTERFACE = define(10221)
    val CURLOPT_DNS_LOCAL_IP4 = define(10222)
    val CURLOPT_DNS_LOCAL_IP6 = define(10223)
    val CURLOPT_LOGIN_OPTIONS = define(10224)
    val CURLOPT_SSL_ENABLE_NPN = define(225)
    val CURLOPT_SSL_ENABLE_ALPN = define(226)
    val CURLOPT_EXPECT_100_TIMEOUT_MS = define(227)
    val CURLOPT_PROXYHEADER = define(10228)
    val CURLOPT_HEADEROPT = define(229)
    val CURLOPT_PINNEDPUBLICKEY = define(10230)
    val CURLOPT_UNIX_SOCKET_PATH = define(10231)
    val CURLOPT_SSL_VERIFYSTATUS = define(232)
    val CURLOPT_SSL_FALSESTART = define(233)
    val CURLOPT_PATH_AS_IS = define(234)
    val CURLOPT_PROXY_SERVICE_NAME = define(10235)
    val CURLOPT_SERVICE_NAME = define(10236)
    val CURLOPT_PIPEWAIT = define(237)
    val CURLOPT_DEFAULT_PROTOCOL = define(10238)
    val CURLOPT_STREAM_WEIGHT = define(239)
    val CURLOPT_STREAM_DEPENDS = define(10240)
    val CURLOPT_STREAM_DEPENDS_E = define(10241)
    val CURLOPT_TFTP_NO_OPTIONS = define(242)
    val CURLOPT_CONNECT_TO = define(10243)
    val CURLOPT_TCP_FASTOPEN = define(244)
    val CURLOPT_KEEP_SENDING_ON_ERROR = define(245)
    val CURLOPT_PROXY_CAINFO = define(10246)
    val CURLOPT_PROXY_CAPATH = define(10247)
    val CURLOPT_PROXY_SSL_VERIFYPEER = define(248)
    val CURLOPT_PROXY_SSL_VERIFYHOST = define(249)
    val CURLOPT_PROXY_SSLVERSION = define(250)
    val CURLOPT_PROXY_TLSAUTH_USERNAME = define(10251)
    val CURLOPT_PROXY_TLSAUTH_PASSWORD = define(10252)
    val CURLOPT_PROXY_TLSAUTH_TYPE = define(10253)
    val CURLOPT_PROXY_SSLCERT = define(10254)
    val CURLOPT_PROXY_SSLCERTTYPE = define(10255)
    val CURLOPT_PROXY_SSLKEY = define(10256)
    val CURLOPT_PROXY_SSLKEYTYPE = define(10257)
    val CURLOPT_PROXY_KEYPASSWD = define(10258)
    val CURLOPT_PROXY_SSL_CIPHER_LIST = define(10259)
    val CURLOPT_PROXY_CRLFILE = define(10260)
    val CURLOPT_PROXY_SSL_OPTIONS = define(261)
    val CURLOPT_PRE_PROXY = define(10262)
    val CURLOPT_PROXY_PINNEDPUBLICKEY = define(10263)
    val CURLOPT_ABSTRACT_UNIX_SOCKET = define(10264)
    val CURLOPT_SUPPRESS_CONNECT_HEADERS = define(265)
    val CURLOPT_REQUEST_TARGET = define(10266)
    val CURLOPT_SOCKS5_AUTH = define(267)
    val CURLOPT_SSH_COMPRESSION = define(268)
    val CURLOPT_MIMEPOST = define(10269)
    val CURLOPT_TIMEVALUE_LARGE = define(30270)
    val CURLOPT_HAPPY_EYEBALLS_TIMEOUT_MS = define(271)
    val CURLOPT_RESOLVER_START_FUNCTION = define(20272)
    val CURLOPT_RESOLVER_START_DATA = define(10273)
    val CURLOPT_HAPROXYPROTOCOL = define(274)
    val CURLOPT_DNS_SHUFFLE_ADDRESSES = define(275)
    val CURLOPT_TLS13_CIPHERS = define(10276)
    val CURLOPT_PROXY_TLS13_CIPHERS = define(10277)
    val CURLOPT_DISALLOW_USERNAME_IN_URL = define(278)
    val CURLOPT_DOH_URL = define(10279)
    val CURLOPT_UPLOAD_BUFFERSIZE = define(280)
    val CURLOPT_UPKEEP_INTERVAL_MS = define(281)
    val CURLOPT_CURLU = define(10282)
    val CURLOPT_TRAILERFUNCTION = define(20283)
    val CURLOPT_TRAILERDATA = define(10284)
    val CURLOPT_HTTP09_ALLOWED = define(285)
    val CURLOPT_ALTSVC_CTRL = define(286)
    val CURLOPT_ALTSVC = define(10287)
    val CURLOPT_MAXAGE_CONN = define(288)
    val CURLOPT_SASL_AUTHZID = define(10289)
    val CURLOPT_MAIL_RCPT_ALLLOWFAILS = define(290)
    val CURLOPT_SSLCERT_BLOB = define(40291)
    val CURLOPT_SSLKEY_BLOB = define(40292)
    val CURLOPT_PROXY_SSLCERT_BLOB = define(40293)
    val CURLOPT_PROXY_SSLKEY_BLOB = define(40294)
    val CURLOPT_ISSUERCERT_BLOB = define(40295)
    val CURLOPT_PROXY_ISSUERCERT = define(10296)
    val CURLOPT_PROXY_ISSUERCERT_BLOB = define(40297)
    val CURLOPT_SSL_EC_CURVES = define(10298)
    val CURLOPT_HSTS_CTRL = define(299)
    val CURLOPT_HSTS = define(10300)
    val CURLOPT_HSTSREADFUNCTION = define(20301)
    val CURLOPT_HSTSREADDATA = define(10302)
    val CURLOPT_HSTSWRITEFUNCTION = define(20303)
    val CURLOPT_HSTSWRITEDATA = define(10304)
    val CURLOPT_AWS_SIGV4 = define(10305)
    val CURLOPT_DOH_SSL_VERIFYPEER = define(306)
    val CURLOPT_DOH_SSL_VERIFYHOST = define(307)
    val CURLOPT_DOH_SSL_VERIFYSTATUS = define(308)
    val CURLOPT_CAINFO_BLOB = define(40309)
    val CURLOPT_PROXY_CAINFO_BLOB = define(40310)
    val CURLOPT_SSH_HOST_PUBLIC_KEY_SHA256 = define(10311)
    val CURLOPT_PREREQFUNCTION = define(20312)
    val CURLOPT_PREREQDATA = define(10313)
    val CURLOPT_MAXLIFETIME_CONN = define(314)
    val CURLOPT_MIME_OPTIONS = define(315)
    val CURLOPT_LASTENTRY = define(316)

  opaque type CURLproxycode = CUnsignedInt
  object CURLproxycode extends CEnumU[CURLproxycode]:
    inline def define(inline a: Long): CURLproxycode = a.toUInt
    val CURLPX_OK = define(0)
    val CURLPX_BAD_ADDRESS_TYPE = define(1)
    val CURLPX_BAD_VERSION = define(2)
    val CURLPX_CLOSED = define(3)
    val CURLPX_GSSAPI = define(4)
    val CURLPX_GSSAPI_PERMSG = define(5)
    val CURLPX_GSSAPI_PROTECTION = define(6)
    val CURLPX_IDENTD = define(7)
    val CURLPX_IDENTD_DIFFER = define(8)
    val CURLPX_LONG_HOSTNAME = define(9)
    val CURLPX_LONG_PASSWD = define(10)
    val CURLPX_LONG_USER = define(11)
    val CURLPX_NO_AUTH = define(12)
    val CURLPX_RECV_ADDRESS = define(13)
    val CURLPX_RECV_AUTH = define(14)
    val CURLPX_RECV_CONNECT = define(15)
    val CURLPX_RECV_REQACK = define(16)
    val CURLPX_REPLY_ADDRESS_TYPE_NOT_SUPPORTED = define(17)
    val CURLPX_REPLY_COMMAND_NOT_SUPPORTED = define(18)
    val CURLPX_REPLY_CONNECTION_REFUSED = define(19)
    val CURLPX_REPLY_GENERAL_SERVER_FAILURE = define(20)
    val CURLPX_REPLY_HOST_UNREACHABLE = define(21)
    val CURLPX_REPLY_NETWORK_UNREACHABLE = define(22)
    val CURLPX_REPLY_NOT_ALLOWED = define(23)
    val CURLPX_REPLY_TTL_EXPIRED = define(24)
    val CURLPX_REPLY_UNASSIGNED = define(25)
    val CURLPX_REQUEST_FAILED = define(26)
    val CURLPX_RESOLVE_HOST = define(27)
    val CURLPX_SEND_AUTH = define(28)
    val CURLPX_SEND_CONNECT = define(29)
    val CURLPX_SEND_REQUEST = define(30)
    val CURLPX_UNKNOWN_FAIL = define(31)
    val CURLPX_UNKNOWN_MODE = define(32)
    val CURLPX_USER_REJECTED = define(33)
    val CURLPX_LAST = define(34)

  opaque type CURLsslset = CUnsignedInt
  object CURLsslset extends CEnumU[CURLsslset]:
    inline def define(inline a: Long): CURLsslset = a.toUInt
    val CURLSSLSET_OK = define(0)
    val CURLSSLSET_UNKNOWN_BACKEND = define(1)
    val CURLSSLSET_TOO_LATE = define(2)
    val CURLSSLSET_NO_BACKENDS = define(3)

  opaque type CURLversion = CUnsignedInt
  object CURLversion extends CEnumU[CURLversion]:
    inline def define(inline a: Long): CURLversion = a.toUInt
    val CURLVERSION_FIRST = define(0)
    val CURLVERSION_SECOND = define(1)
    val CURLVERSION_THIRD = define(2)
    val CURLVERSION_FOURTH = define(3)
    val CURLVERSION_FIFTH = define(4)
    val CURLVERSION_SIXTH = define(5)
    val CURLVERSION_SEVENTH = define(6)
    val CURLVERSION_EIGHTH = define(7)
    val CURLVERSION_NINTH = define(8)
    val CURLVERSION_TENTH = define(9)
    val CURLVERSION_LAST = define(10)

  opaque type clockid_t = CUnsignedInt
  object clockid_t extends CEnumU[clockid_t]:
    inline def define(inline a: Long): clockid_t = a.toUInt
    val _CLOCK_REALTIME = define(0)
    val _CLOCK_MONOTONIC = define(6)
    val _CLOCK_MONOTONIC_RAW = define(4)
    val _CLOCK_MONOTONIC_RAW_APPROX = define(5)
    val _CLOCK_UPTIME_RAW = define(8)
    val _CLOCK_UPTIME_RAW_APPROX = define(9)
    val _CLOCK_PROCESS_CPUTIME_ID = define(12)
    val _CLOCK_THREAD_CPUTIME_ID = define(16)

  opaque type curl_TimeCond = CUnsignedInt
  object curl_TimeCond extends CEnumU[curl_TimeCond]:
    inline def define(inline a: Long): curl_TimeCond = a.toUInt
    val CURL_TIMECOND_NONE = define(0)
    val CURL_TIMECOND_IFMODSINCE = define(1)
    val CURL_TIMECOND_IFUNMODSINCE = define(2)
    val CURL_TIMECOND_LASTMOD = define(3)
    val CURL_TIMECOND_LAST = define(4)

  opaque type curl_closepolicy = CUnsignedInt
  object curl_closepolicy extends CEnumU[curl_closepolicy]:
    inline def define(inline a: Long): curl_closepolicy = a.toUInt
    val CURLCLOSEPOLICY_NONE = define(0)
    val CURLCLOSEPOLICY_OLDEST = define(1)
    val CURLCLOSEPOLICY_LEAST_RECENTLY_USED = define(2)
    val CURLCLOSEPOLICY_LEAST_TRAFFIC = define(3)
    val CURLCLOSEPOLICY_SLOWEST = define(4)
    val CURLCLOSEPOLICY_CALLBACK = define(5)
    val CURLCLOSEPOLICY_LAST = define(6)

  opaque type curl_easytype = CUnsignedInt
  object curl_easytype extends CEnumU[curl_easytype]:
    inline def define(inline a: Long): curl_easytype = a.toUInt
    val CURLOT_LONG = define(0)
    val CURLOT_VALUES = define(1)
    val CURLOT_OFF_T = define(2)
    val CURLOT_OBJECT = define(3)
    val CURLOT_STRING = define(4)
    val CURLOT_SLIST = define(5)
    val CURLOT_CBPTR = define(6)
    val CURLOT_BLOB = define(7)
    val CURLOT_FUNCTION = define(8)

  opaque type curl_ftpauth = CUnsignedInt
  object curl_ftpauth extends CEnumU[curl_ftpauth]:
    inline def define(inline a: Long): curl_ftpauth = a.toUInt
    val CURLFTPAUTH_DEFAULT = define(0)
    val CURLFTPAUTH_SSL = define(1)
    val CURLFTPAUTH_TLS = define(2)
    val CURLFTPAUTH_LAST = define(3)

  opaque type curl_ftpccc = CUnsignedInt
  object curl_ftpccc extends CEnumU[curl_ftpccc]:
    inline def define(inline a: Long): curl_ftpccc = a.toUInt
    val CURLFTPSSL_CCC_NONE = define(0)
    val CURLFTPSSL_CCC_PASSIVE = define(1)
    val CURLFTPSSL_CCC_ACTIVE = define(2)
    val CURLFTPSSL_CCC_LAST = define(3)

  opaque type curl_ftpcreatedir = CUnsignedInt
  object curl_ftpcreatedir extends CEnumU[curl_ftpcreatedir]:
    inline def define(inline a: Long): curl_ftpcreatedir = a.toUInt
    val CURLFTP_CREATE_DIR_NONE = define(0)
    val CURLFTP_CREATE_DIR = define(1)
    val CURLFTP_CREATE_DIR_RETRY = define(2)
    val CURLFTP_CREATE_DIR_LAST = define(3)

  opaque type curl_ftpmethod = CUnsignedInt
  object curl_ftpmethod extends CEnumU[curl_ftpmethod]:
    inline def define(inline a: Long): curl_ftpmethod = a.toUInt
    val CURLFTPMETHOD_DEFAULT = define(0)
    val CURLFTPMETHOD_MULTICWD = define(1)
    val CURLFTPMETHOD_NOCWD = define(2)
    val CURLFTPMETHOD_SINGLECWD = define(3)
    val CURLFTPMETHOD_LAST = define(4)

  opaque type curl_infotype = CUnsignedInt
  object curl_infotype extends CEnumU[curl_infotype]:
    inline def define(inline a: Long): curl_infotype = a.toUInt
    val CURLINFO_TEXT = define(0)
    val CURLINFO_HEADER_IN = define(1)
    val CURLINFO_HEADER_OUT = define(2)
    val CURLINFO_DATA_IN = define(3)
    val CURLINFO_DATA_OUT = define(4)
    val CURLINFO_SSL_DATA_IN = define(5)
    val CURLINFO_SSL_DATA_OUT = define(6)
    val CURLINFO_END = define(7)

  opaque type curl_khmatch = CUnsignedInt
  object curl_khmatch extends CEnumU[curl_khmatch]:
    inline def define(inline a: Long): curl_khmatch = a.toUInt
    val CURLKHMATCH_OK = define(0)
    val CURLKHMATCH_MISMATCH = define(1)
    val CURLKHMATCH_MISSING = define(2)
    val CURLKHMATCH_LAST = define(3)

  opaque type curl_khstat = CUnsignedInt
  object curl_khstat extends CEnumU[curl_khstat]:
    inline def define(inline a: Long): curl_khstat = a.toUInt
    val CURLKHSTAT_FINE_ADD_TO_FILE = define(0)
    val CURLKHSTAT_FINE = define(1)
    val CURLKHSTAT_REJECT = define(2)
    val CURLKHSTAT_DEFER = define(3)
    val CURLKHSTAT_FINE_REPLACE = define(4)
    val CURLKHSTAT_LAST = define(5)

  opaque type curl_khtype = CUnsignedInt
  object curl_khtype extends CEnumU[curl_khtype]:
    inline def define(inline a: Long): curl_khtype = a.toUInt
    val CURLKHTYPE_UNKNOWN = define(0)
    val CURLKHTYPE_RSA1 = define(1)
    val CURLKHTYPE_RSA = define(2)
    val CURLKHTYPE_DSS = define(3)
    val CURLKHTYPE_ECDSA = define(4)
    val CURLKHTYPE_ED25519 = define(5)

  opaque type curl_lock_access = CUnsignedInt
  object curl_lock_access extends CEnumU[curl_lock_access]:
    inline def define(inline a: Long): curl_lock_access = a.toUInt
    val CURL_LOCK_ACCESS_NONE = define(0)
    val CURL_LOCK_ACCESS_SHARED = define(1)
    val CURL_LOCK_ACCESS_SINGLE = define(2)
    val CURL_LOCK_ACCESS_LAST = define(3)

  opaque type curl_lock_data = CUnsignedInt
  object curl_lock_data extends CEnumU[curl_lock_data]:
    inline def define(inline a: Long): curl_lock_data = a.toUInt
    val CURL_LOCK_DATA_NONE = define(0)
    val CURL_LOCK_DATA_SHARE = define(1)
    val CURL_LOCK_DATA_COOKIE = define(2)
    val CURL_LOCK_DATA_DNS = define(3)
    val CURL_LOCK_DATA_SSL_SESSION = define(4)
    val CURL_LOCK_DATA_CONNECT = define(5)
    val CURL_LOCK_DATA_PSL = define(6)
    val CURL_LOCK_DATA_LAST = define(7)

  opaque type curl_proxytype = CUnsignedInt
  object curl_proxytype extends CEnumU[curl_proxytype]:
    inline def define(inline a: Long): curl_proxytype = a.toUInt
    val CURLPROXY_HTTP = define(0)
    val CURLPROXY_HTTP_1_0 = define(1)
    val CURLPROXY_HTTPS = define(2)
    val CURLPROXY_SOCKS4 = define(4)
    val CURLPROXY_SOCKS5 = define(5)
    val CURLPROXY_SOCKS4A = define(6)
    val CURLPROXY_SOCKS5_HOSTNAME = define(7)

  opaque type curl_sslbackend = CUnsignedInt
  object curl_sslbackend extends CEnumU[curl_sslbackend]:
    inline def define(inline a: Long): curl_sslbackend = a.toUInt
    val CURLSSLBACKEND_NONE = define(0)
    val CURLSSLBACKEND_OPENSSL = define(1)
    val CURLSSLBACKEND_GNUTLS = define(2)
    val CURLSSLBACKEND_NSS = define(3)
    val CURLSSLBACKEND_OBSOLETE4 = define(4)
    val CURLSSLBACKEND_GSKIT = define(5)
    val CURLSSLBACKEND_POLARSSL = define(6)
    val CURLSSLBACKEND_WOLFSSL = define(7)
    val CURLSSLBACKEND_SCHANNEL = define(8)
    val CURLSSLBACKEND_SECURETRANSPORT = define(9)
    val CURLSSLBACKEND_AXTLS = define(10)
    val CURLSSLBACKEND_MBEDTLS = define(11)
    val CURLSSLBACKEND_MESALINK = define(12)
    val CURLSSLBACKEND_BEARSSL = define(13)
    val CURLSSLBACKEND_RUSTLS = define(14)

  opaque type curl_usessl = CUnsignedInt
  object curl_usessl extends CEnumU[curl_usessl]:
    inline def define(inline a: Long): curl_usessl = a.toUInt
    val CURLUSESSL_NONE = define(0)
    val CURLUSESSL_TRY = define(1)
    val CURLUSESSL_CONTROL = define(2)
    val CURLUSESSL_ALL = define(3)
    val CURLUSESSL_LAST = define(4)

  opaque type curlfiletype = CUnsignedInt
  object curlfiletype extends CEnumU[curlfiletype]:
    inline def define(inline a: Long): curlfiletype = a.toUInt
    val CURLFILETYPE_FILE = define(0)
    val CURLFILETYPE_DIRECTORY = define(1)
    val CURLFILETYPE_SYMLINK = define(2)
    val CURLFILETYPE_DEVICE_BLOCK = define(3)
    val CURLFILETYPE_DEVICE_CHAR = define(4)
    val CURLFILETYPE_NAMEDPIPE = define(5)
    val CURLFILETYPE_SOCKET = define(6)
    val CURLFILETYPE_DOOR = define(7)
    val CURLFILETYPE_UNKNOWN = define(8)

  opaque type curliocmd = CUnsignedInt
  object curliocmd extends CEnumU[curliocmd]:
    inline def define(inline a: Long): curliocmd = a.toUInt
    val CURLIOCMD_NOP = define(0)
    val CURLIOCMD_RESTARTREAD = define(1)
    val CURLIOCMD_LAST = define(2)

  opaque type curlioerr = CUnsignedInt
  object curlioerr extends CEnumU[curlioerr]:
    inline def define(inline a: Long): curlioerr = a.toUInt
    val CURLIOE_OK = define(0)
    val CURLIOE_UNKNOWNCMD = define(1)
    val CURLIOE_FAILRESTART = define(2)
    val CURLIOE_LAST = define(3)

  opaque type curlsocktype = CUnsignedInt
  object curlsocktype extends CEnumU[curlsocktype]:
    inline def define(inline a: Long): curlsocktype = a.toUInt
    val CURLSOCKTYPE_IPCXN = define(0)
    val CURLSOCKTYPE_ACCEPT = define(1)
    val CURLSOCKTYPE_LAST = define(2)
  type CURL = Unit
  object CURL: 
    given _tag: Tag[CURL] = Tag.Unit

  type CURLM = Unit
  object CURLM: 
    given _tag: Tag[CURLM] = Tag.Unit

  type CURLSH = Unit
  object CURLSH: 
    given _tag: Tag[CURLSH] = Tag.Unit

  opaque type __builtin_va_list = CString
  object __builtin_va_list: 
    given _tag: Tag[__builtin_va_list] = Tag.Ptr[CChar](Tag.Byte)
    inline def apply(inline o: CString): __builtin_va_list = o

  type __darwin_blkcnt_t = __int64_t
  object __darwin_blkcnt_t: 
    given _tag: Tag[__darwin_blkcnt_t] = __int64_t._tag

  type __darwin_blksize_t = __int32_t
  object __darwin_blksize_t: 
    given _tag: Tag[__darwin_blksize_t] = __int32_t._tag

  opaque type __darwin_clock_t = CUnsignedLongInt
  object __darwin_clock_t: 
    given _tag: Tag[__darwin_clock_t] = Tag.ULong
    inline def apply(inline o: CUnsignedLongInt): __darwin_clock_t = o

  opaque type __darwin_ct_rune_t = CInt
  object __darwin_ct_rune_t: 
    given _tag: Tag[__darwin_ct_rune_t] = Tag.Int
    inline def apply(inline o: CInt): __darwin_ct_rune_t = o

  type __darwin_dev_t = __int32_t
  object __darwin_dev_t: 
    given _tag: Tag[__darwin_dev_t] = __int32_t._tag

  opaque type __darwin_fsblkcnt_t = CUnsignedInt
  object __darwin_fsblkcnt_t: 
    given _tag: Tag[__darwin_fsblkcnt_t] = Tag.UInt
    inline def apply(inline o: CUnsignedInt): __darwin_fsblkcnt_t = o

  opaque type __darwin_fsfilcnt_t = CUnsignedInt
  object __darwin_fsfilcnt_t: 
    given _tag: Tag[__darwin_fsfilcnt_t] = Tag.UInt
    inline def apply(inline o: CUnsignedInt): __darwin_fsfilcnt_t = o

  type __darwin_gid_t = __uint32_t
  object __darwin_gid_t: 
    given _tag: Tag[__darwin_gid_t] = __uint32_t._tag

  type __darwin_id_t = __uint32_t
  object __darwin_id_t: 
    given _tag: Tag[__darwin_id_t] = __uint32_t._tag

  type __darwin_ino64_t = __uint64_t
  object __darwin_ino64_t: 
    given _tag: Tag[__darwin_ino64_t] = __uint64_t._tag

  type __darwin_ino_t = __darwin_ino64_t
  object __darwin_ino_t: 
    given _tag: Tag[__darwin_ino_t] = __darwin_ino64_t._tag

  opaque type __darwin_intptr_t = CLongInt
  object __darwin_intptr_t: 
    given _tag: Tag[__darwin_intptr_t] = Tag.Long
    inline def apply(inline o: CLongInt): __darwin_intptr_t = o

  type __darwin_mach_port_name_t = __darwin_natural_t
  object __darwin_mach_port_name_t: 
    given _tag: Tag[__darwin_mach_port_name_t] = __darwin_natural_t._tag

  type __darwin_mach_port_t = __darwin_mach_port_name_t
  object __darwin_mach_port_t: 
    given _tag: Tag[__darwin_mach_port_t] = __darwin_mach_port_name_t._tag

  type __darwin_mbstate_t = __mbstate_t
  object __darwin_mbstate_t: 
    given _tag: Tag[__darwin_mbstate_t] = __mbstate_t._tag

  type __darwin_mode_t = __uint16_t
  object __darwin_mode_t: 
    given _tag: Tag[__darwin_mode_t] = __uint16_t._tag

  opaque type __darwin_natural_t = CUnsignedInt
  object __darwin_natural_t: 
    given _tag: Tag[__darwin_natural_t] = Tag.UInt
    inline def apply(inline o: CUnsignedInt): __darwin_natural_t = o

  opaque type __darwin_nl_item = CInt
  object __darwin_nl_item: 
    given _tag: Tag[__darwin_nl_item] = Tag.Int
    inline def apply(inline o: CInt): __darwin_nl_item = o

  type __darwin_off_t = __int64_t
  object __darwin_off_t: 
    given _tag: Tag[__darwin_off_t] = __int64_t._tag

  type __darwin_pid_t = __int32_t
  object __darwin_pid_t: 
    given _tag: Tag[__darwin_pid_t] = __int32_t._tag

  opaque type __darwin_pthread_key_t = CUnsignedLongInt
  object __darwin_pthread_key_t: 
    given _tag: Tag[__darwin_pthread_key_t] = Tag.ULong
    inline def apply(inline o: CUnsignedLongInt): __darwin_pthread_key_t = o

  opaque type __darwin_pthread_t = Ptr[_opaque_pthread_t]
  object __darwin_pthread_t: 
    given _tag: Tag[__darwin_pthread_t] = Tag.Ptr[_opaque_pthread_t](_opaque_pthread_t._tag)
    inline def apply(inline o: Ptr[_opaque_pthread_t]): __darwin_pthread_t = o

  opaque type __darwin_ptrdiff_t = CLongInt
  object __darwin_ptrdiff_t: 
    given _tag: Tag[__darwin_ptrdiff_t] = Tag.Long
    inline def apply(inline o: CLongInt): __darwin_ptrdiff_t = o

  type __darwin_rune_t = __darwin_wchar_t
  object __darwin_rune_t: 
    given _tag: Tag[__darwin_rune_t] = __darwin_wchar_t._tag

  type __darwin_sigset_t = __uint32_t
  object __darwin_sigset_t: 
    given _tag: Tag[__darwin_sigset_t] = __uint32_t._tag

  opaque type __darwin_size_t = CUnsignedLongInt
  object __darwin_size_t: 
    given _tag: Tag[__darwin_size_t] = Tag.ULong
    inline def apply(inline o: CUnsignedLongInt): __darwin_size_t = o

  type __darwin_socklen_t = __uint32_t
  object __darwin_socklen_t: 
    given _tag: Tag[__darwin_socklen_t] = __uint32_t._tag

  opaque type __darwin_ssize_t = CLongInt
  object __darwin_ssize_t: 
    given _tag: Tag[__darwin_ssize_t] = Tag.Long
    inline def apply(inline o: CLongInt): __darwin_ssize_t = o

  type __darwin_suseconds_t = __int32_t
  object __darwin_suseconds_t: 
    given _tag: Tag[__darwin_suseconds_t] = __int32_t._tag

  opaque type __darwin_time_t = CLongInt
  object __darwin_time_t: 
    given _tag: Tag[__darwin_time_t] = Tag.Long
    inline def apply(inline o: CLongInt): __darwin_time_t = o

  type __darwin_uid_t = __uint32_t
  object __darwin_uid_t: 
    given _tag: Tag[__darwin_uid_t] = __uint32_t._tag

  type __darwin_useconds_t = __uint32_t
  object __darwin_useconds_t: 
    given _tag: Tag[__darwin_useconds_t] = __uint32_t._tag

  opaque type __darwin_uuid_string_t = CArray[CChar, Nat.Digit2[Nat._3, Nat._7]]
  object __darwin_uuid_string_t: 
    given _tag: Tag[__darwin_uuid_string_t] = Tag.CArray[CChar, Nat.Digit2[Nat._3, Nat._7]](Tag.Byte, Tag.Digit2[Nat._3, Nat._7](Tag.Nat3, Tag.Nat7))
    inline def apply(inline o: CArray[CChar, Nat.Digit2[Nat._3, Nat._7]]): __darwin_uuid_string_t = o

  opaque type __darwin_uuid_t = CArray[CUnsignedChar, Nat.Digit2[Nat._1, Nat._6]]
  object __darwin_uuid_t: 
    given _tag: Tag[__darwin_uuid_t] = Tag.CArray[CUnsignedChar, Nat.Digit2[Nat._1, Nat._6]](Tag.UByte, Tag.Digit2[Nat._1, Nat._6](Tag.Nat1, Tag.Nat6))
    inline def apply(inline o: CArray[CUnsignedChar, Nat.Digit2[Nat._1, Nat._6]]): __darwin_uuid_t = o

  type __darwin_va_list = __builtin_va_list
  object __darwin_va_list: 
    given _tag: Tag[__darwin_va_list] = __builtin_va_list._tag

  opaque type __darwin_wchar_t = CInt
  object __darwin_wchar_t: 
    given _tag: Tag[__darwin_wchar_t] = Tag.Int
    inline def apply(inline o: CInt): __darwin_wchar_t = o

  opaque type __darwin_wctrans_t = CInt
  object __darwin_wctrans_t: 
    given _tag: Tag[__darwin_wctrans_t] = Tag.Int
    inline def apply(inline o: CInt): __darwin_wctrans_t = o

  type __darwin_wctype_t = __uint32_t
  object __darwin_wctype_t: 
    given _tag: Tag[__darwin_wctype_t] = __uint32_t._tag

  opaque type __darwin_wint_t = CInt
  object __darwin_wint_t: 
    given _tag: Tag[__darwin_wint_t] = Tag.Int
    inline def apply(inline o: CInt): __darwin_wint_t = o

  opaque type __int16_t = CShort
  object __int16_t: 
    given _tag: Tag[__int16_t] = Tag.Short
    inline def apply(inline o: CShort): __int16_t = o

  opaque type __int32_t = CInt
  object __int32_t: 
    given _tag: Tag[__int32_t] = Tag.Int
    inline def apply(inline o: CInt): __int32_t = o

  opaque type __int64_t = CLongLong
  object __int64_t: 
    given _tag: Tag[__int64_t] = Tag.Long
    inline def apply(inline o: CLongLong): __int64_t = o

  opaque type __int8_t = CChar
  object __int8_t: 
    given _tag: Tag[__int8_t] = Tag.Byte
    inline def apply(inline o: CChar): __int8_t = o

  opaque type __uint16_t = CUnsignedShort
  object __uint16_t: 
    given _tag: Tag[__uint16_t] = Tag.UShort
    inline def apply(inline o: CUnsignedShort): __uint16_t = o

  opaque type __uint32_t = CUnsignedInt
  object __uint32_t: 
    given _tag: Tag[__uint32_t] = Tag.UInt
    inline def apply(inline o: CUnsignedInt): __uint32_t = o

  opaque type __uint64_t = CUnsignedLongLong
  object __uint64_t: 
    given _tag: Tag[__uint64_t] = Tag.ULong
    inline def apply(inline o: CUnsignedLongLong): __uint64_t = o

  opaque type __uint8_t = CUnsignedChar
  object __uint8_t: 
    given _tag: Tag[__uint8_t] = Tag.UByte
    inline def apply(inline o: CUnsignedChar): __uint8_t = o

  type blkcnt_t = __darwin_blkcnt_t
  object blkcnt_t: 
    given _tag: Tag[blkcnt_t] = __darwin_blkcnt_t._tag

  type blksize_t = __darwin_blksize_t
  object blksize_t: 
    given _tag: Tag[blksize_t] = __darwin_blksize_t._tag

  opaque type caddr_t = CString
  object caddr_t: 
    given _tag: Tag[caddr_t] = Tag.Ptr[CChar](Tag.Byte)
    inline def apply(inline o: CString): caddr_t = o

  type clock_t = __darwin_clock_t
  object clock_t: 
    given _tag: Tag[clock_t] = __darwin_clock_t._tag

  opaque type curl_calloc_callback = CFuncPtr2[size_t, size_t, Ptr[Byte]]
  object curl_calloc_callback: 
    given _tag: Tag[curl_calloc_callback] = Tag.materializeCFuncPtr2[size_t, size_t, Ptr[Byte]]
    inline def apply(inline o: CFuncPtr2[size_t, size_t, Ptr[Byte]]): curl_calloc_callback = o

  opaque type curl_chunk_bgn_callback = CFuncPtr3[Ptr[Byte], Ptr[Byte], CInt, CLongInt]
  object curl_chunk_bgn_callback: 
    given _tag: Tag[curl_chunk_bgn_callback] = Tag.materializeCFuncPtr3[Ptr[Byte], Ptr[Byte], CInt, CLongInt]
    inline def apply(inline o: CFuncPtr3[Ptr[Byte], Ptr[Byte], CInt, CLongInt]): curl_chunk_bgn_callback = o

  opaque type curl_chunk_end_callback = CFuncPtr1[Ptr[Byte], CLongInt]
  object curl_chunk_end_callback: 
    given _tag: Tag[curl_chunk_end_callback] = Tag.materializeCFuncPtr1[Ptr[Byte], CLongInt]
    inline def apply(inline o: CFuncPtr1[Ptr[Byte], CLongInt]): curl_chunk_end_callback = o

  opaque type curl_closesocket_callback = CFuncPtr2[Ptr[Byte], curl_socket_t, CInt]
  object curl_closesocket_callback: 
    given _tag: Tag[curl_closesocket_callback] = Tag.materializeCFuncPtr2[Ptr[Byte], curl_socket_t, CInt]
    inline def apply(inline o: CFuncPtr2[Ptr[Byte], curl_socket_t, CInt]): curl_closesocket_callback = o

  opaque type curl_conv_callback = CFuncPtr2[CString, size_t, CURLcode]
  object curl_conv_callback: 
    given _tag: Tag[curl_conv_callback] = Tag.materializeCFuncPtr2[CString, size_t, CURLcode]
    inline def apply(inline o: CFuncPtr2[CString, size_t, CURLcode]): curl_conv_callback = o

  opaque type curl_debug_callback = CFuncPtr5[Ptr[CURL], curl_infotype, CString, size_t, Ptr[Byte], CInt]
  object curl_debug_callback: 
    given _tag: Tag[curl_debug_callback] = Tag.materializeCFuncPtr5[Ptr[CURL], curl_infotype, CString, size_t, Ptr[Byte], CInt]
    inline def apply(inline o: CFuncPtr5[Ptr[CURL], curl_infotype, CString, size_t, Ptr[Byte], CInt]): curl_debug_callback = o

  opaque type curl_fnmatch_callback = CFuncPtr3[Ptr[Byte], CString, CString, CInt]
  object curl_fnmatch_callback: 
    given _tag: Tag[curl_fnmatch_callback] = Tag.materializeCFuncPtr3[Ptr[Byte], CString, CString, CInt]
    inline def apply(inline o: CFuncPtr3[Ptr[Byte], CString, CString, CInt]): curl_fnmatch_callback = o

  opaque type curl_formget_callback = CFuncPtr3[Ptr[Byte], CString, size_t, size_t]
  object curl_formget_callback: 
    given _tag: Tag[curl_formget_callback] = Tag.materializeCFuncPtr3[Ptr[Byte], CString, size_t, size_t]
    inline def apply(inline o: CFuncPtr3[Ptr[Byte], CString, size_t, size_t]): curl_formget_callback = o

  opaque type curl_free_callback = CFuncPtr1[Ptr[Byte], Unit]
  object curl_free_callback: 
    given _tag: Tag[curl_free_callback] = Tag.materializeCFuncPtr1[Ptr[Byte], Unit]
    inline def apply(inline o: CFuncPtr1[Ptr[Byte], Unit]): curl_free_callback = o

  opaque type curl_hstsread_callback = CFuncPtr3[Ptr[CURL], Ptr[curl_hstsentry], Ptr[Byte], CURLSTScode]
  object curl_hstsread_callback: 
    given _tag: Tag[curl_hstsread_callback] = Tag.materializeCFuncPtr3[Ptr[CURL], Ptr[curl_hstsentry], Ptr[Byte], CURLSTScode]
    inline def apply(inline o: CFuncPtr3[Ptr[CURL], Ptr[curl_hstsentry], Ptr[Byte], CURLSTScode]): curl_hstsread_callback = o

  opaque type curl_hstswrite_callback = CFuncPtr4[Ptr[CURL], Ptr[curl_hstsentry], Ptr[curl_index], Ptr[Byte], CURLSTScode]
  object curl_hstswrite_callback: 
    given _tag: Tag[curl_hstswrite_callback] = Tag.materializeCFuncPtr4[Ptr[CURL], Ptr[curl_hstsentry], Ptr[curl_index], Ptr[Byte], CURLSTScode]
    inline def apply(inline o: CFuncPtr4[Ptr[CURL], Ptr[curl_hstsentry], Ptr[curl_index], Ptr[Byte], CURLSTScode]): curl_hstswrite_callback = o

  opaque type curl_ioctl_callback = CFuncPtr3[Ptr[CURL], CInt, Ptr[Byte], curlioerr]
  object curl_ioctl_callback: 
    given _tag: Tag[curl_ioctl_callback] = Tag.materializeCFuncPtr3[Ptr[CURL], CInt, Ptr[Byte], curlioerr]
    inline def apply(inline o: CFuncPtr3[Ptr[CURL], CInt, Ptr[Byte], curlioerr]): curl_ioctl_callback = o

  opaque type curl_lock_function = CFuncPtr4[Ptr[CURL], curl_lock_data, curl_lock_access, Ptr[Byte], Unit]
  object curl_lock_function: 
    given _tag: Tag[curl_lock_function] = Tag.materializeCFuncPtr4[Ptr[CURL], curl_lock_data, curl_lock_access, Ptr[Byte], Unit]
    inline def apply(inline o: CFuncPtr4[Ptr[CURL], curl_lock_data, curl_lock_access, Ptr[Byte], Unit]): curl_lock_function = o

  opaque type curl_malloc_callback = CFuncPtr1[size_t, Ptr[Byte]]
  object curl_malloc_callback: 
    given _tag: Tag[curl_malloc_callback] = Tag.materializeCFuncPtr1[size_t, Ptr[Byte]]
    inline def apply(inline o: CFuncPtr1[size_t, Ptr[Byte]]): curl_malloc_callback = o

  opaque type curl_multi_timer_callback = CFuncPtr3[Ptr[CURLM], CLongInt, Ptr[Byte], CInt]
  object curl_multi_timer_callback: 
    given _tag: Tag[curl_multi_timer_callback] = Tag.materializeCFuncPtr3[Ptr[CURLM], CLongInt, Ptr[Byte], CInt]
    inline def apply(inline o: CFuncPtr3[Ptr[CURLM], CLongInt, Ptr[Byte], CInt]): curl_multi_timer_callback = o

  opaque type curl_off_t = CLongInt
  object curl_off_t: 
    given _tag: Tag[curl_off_t] = Tag.Long
    inline def apply(inline o: CLongInt): curl_off_t = o

  opaque type curl_opensocket_callback = CFuncPtr3[Ptr[Byte], curlsocktype, Ptr[curl_sockaddr], curl_socket_t]
  object curl_opensocket_callback: 
    given _tag: Tag[curl_opensocket_callback] = Tag.materializeCFuncPtr3[Ptr[Byte], curlsocktype, Ptr[curl_sockaddr], curl_socket_t]
    inline def apply(inline o: CFuncPtr3[Ptr[Byte], curlsocktype, Ptr[curl_sockaddr], curl_socket_t]): curl_opensocket_callback = o

  opaque type curl_prereq_callback = CFuncPtr5[Ptr[Byte], CString, CString, CInt, CInt, CInt]
  object curl_prereq_callback: 
    given _tag: Tag[curl_prereq_callback] = Tag.materializeCFuncPtr5[Ptr[Byte], CString, CString, CInt, CInt, CInt]
    inline def apply(inline o: CFuncPtr5[Ptr[Byte], CString, CString, CInt, CInt, CInt]): curl_prereq_callback = o

  opaque type curl_progress_callback = CFuncPtr5[Ptr[Byte], Double, Double, Double, Double, CInt]
  object curl_progress_callback: 
    given _tag: Tag[curl_progress_callback] = Tag.materializeCFuncPtr5[Ptr[Byte], Double, Double, Double, Double, CInt]
    inline def apply(inline o: CFuncPtr5[Ptr[Byte], Double, Double, Double, Double, CInt]): curl_progress_callback = o

  opaque type curl_push_callback = CFuncPtr5[Ptr[CURL], Ptr[CURL], size_t, Ptr[curl_pushheaders], Ptr[Byte], CInt]
  object curl_push_callback: 
    given _tag: Tag[curl_push_callback] = Tag.materializeCFuncPtr5[Ptr[CURL], Ptr[CURL], size_t, Ptr[curl_pushheaders], Ptr[Byte], CInt]
    inline def apply(inline o: CFuncPtr5[Ptr[CURL], Ptr[CURL], size_t, Ptr[curl_pushheaders], Ptr[Byte], CInt]): curl_push_callback = o

  opaque type curl_read_callback = CFuncPtr4[CString, size_t, size_t, Ptr[Byte], size_t]
  object curl_read_callback: 
    given _tag: Tag[curl_read_callback] = Tag.materializeCFuncPtr4[CString, size_t, size_t, Ptr[Byte], size_t]
    inline def apply(inline o: CFuncPtr4[CString, size_t, size_t, Ptr[Byte], size_t]): curl_read_callback = o

  opaque type curl_realloc_callback = CFuncPtr2[Ptr[Byte], size_t, Ptr[Byte]]
  object curl_realloc_callback: 
    given _tag: Tag[curl_realloc_callback] = Tag.materializeCFuncPtr2[Ptr[Byte], size_t, Ptr[Byte]]
    inline def apply(inline o: CFuncPtr2[Ptr[Byte], size_t, Ptr[Byte]]): curl_realloc_callback = o

  opaque type curl_resolver_start_callback = CFuncPtr3[Ptr[Byte], Ptr[Byte], Ptr[Byte], CInt]
  object curl_resolver_start_callback: 
    given _tag: Tag[curl_resolver_start_callback] = Tag.materializeCFuncPtr3[Ptr[Byte], Ptr[Byte], Ptr[Byte], CInt]
    inline def apply(inline o: CFuncPtr3[Ptr[Byte], Ptr[Byte], Ptr[Byte], CInt]): curl_resolver_start_callback = o

  opaque type curl_seek_callback = CFuncPtr3[Ptr[Byte], curl_off_t, CInt, CInt]
  object curl_seek_callback: 
    given _tag: Tag[curl_seek_callback] = Tag.materializeCFuncPtr3[Ptr[Byte], curl_off_t, CInt, CInt]
    inline def apply(inline o: CFuncPtr3[Ptr[Byte], curl_off_t, CInt, CInt]): curl_seek_callback = o

  opaque type curl_socket_callback = CFuncPtr5[Ptr[CURL], curl_socket_t, CInt, Ptr[Byte], Ptr[Byte], CInt]
  object curl_socket_callback: 
    given _tag: Tag[curl_socket_callback] = Tag.materializeCFuncPtr5[Ptr[CURL], curl_socket_t, CInt, Ptr[Byte], Ptr[Byte], CInt]
    inline def apply(inline o: CFuncPtr5[Ptr[CURL], curl_socket_t, CInt, Ptr[Byte], Ptr[Byte], CInt]): curl_socket_callback = o

  opaque type curl_socket_t = CInt
  object curl_socket_t: 
    given _tag: Tag[curl_socket_t] = Tag.Int
    inline def apply(inline o: CInt): curl_socket_t = o

  type curl_socklen_t = socklen_t
  object curl_socklen_t: 
    given _tag: Tag[curl_socklen_t] = socklen_t._tag

  opaque type curl_sockopt_callback = CFuncPtr3[Ptr[Byte], curl_socket_t, curlsocktype, CInt]
  object curl_sockopt_callback: 
    given _tag: Tag[curl_sockopt_callback] = Tag.materializeCFuncPtr3[Ptr[Byte], curl_socket_t, curlsocktype, CInt]
    inline def apply(inline o: CFuncPtr3[Ptr[Byte], curl_socket_t, curlsocktype, CInt]): curl_sockopt_callback = o

  opaque type curl_sshkeycallback = CFuncPtr5[Ptr[CURL], Ptr[curl_khkey], Ptr[curl_khkey], curl_khmatch, Ptr[Byte], CInt]
  object curl_sshkeycallback: 
    given _tag: Tag[curl_sshkeycallback] = Tag.materializeCFuncPtr5[Ptr[CURL], Ptr[curl_khkey], Ptr[curl_khkey], curl_khmatch, Ptr[Byte], CInt]
    inline def apply(inline o: CFuncPtr5[Ptr[CURL], Ptr[curl_khkey], Ptr[curl_khkey], curl_khmatch, Ptr[Byte], CInt]): curl_sshkeycallback = o

  opaque type curl_ssl_ctx_callback = CFuncPtr3[Ptr[CURL], Ptr[Byte], Ptr[Byte], CURLcode]
  object curl_ssl_ctx_callback: 
    given _tag: Tag[curl_ssl_ctx_callback] = Tag.materializeCFuncPtr3[Ptr[CURL], Ptr[Byte], Ptr[Byte], CURLcode]
    inline def apply(inline o: CFuncPtr3[Ptr[CURL], Ptr[Byte], Ptr[Byte], CURLcode]): curl_ssl_ctx_callback = o

  opaque type curl_strdup_callback = CFuncPtr1[CString, CString]
  object curl_strdup_callback: 
    given _tag: Tag[curl_strdup_callback] = Tag.materializeCFuncPtr1[CString, CString]
    inline def apply(inline o: CFuncPtr1[CString, CString]): curl_strdup_callback = o

  opaque type curl_trailer_callback = CFuncPtr2[Ptr[Ptr[curl_slist]], Ptr[Byte], CInt]
  object curl_trailer_callback: 
    given _tag: Tag[curl_trailer_callback] = Tag.materializeCFuncPtr2[Ptr[Ptr[curl_slist]], Ptr[Byte], CInt]
    inline def apply(inline o: CFuncPtr2[Ptr[Ptr[curl_slist]], Ptr[Byte], CInt]): curl_trailer_callback = o

  opaque type curl_unlock_function = CFuncPtr3[Ptr[CURL], curl_lock_data, Ptr[Byte], Unit]
  object curl_unlock_function: 
    given _tag: Tag[curl_unlock_function] = Tag.materializeCFuncPtr3[Ptr[CURL], curl_lock_data, Ptr[Byte], Unit]
    inline def apply(inline o: CFuncPtr3[Ptr[CURL], curl_lock_data, Ptr[Byte], Unit]): curl_unlock_function = o

  opaque type curl_write_callback = CFuncPtr4[CString, size_t, size_t, Ptr[Byte], size_t]
  object curl_write_callback: 
    given _tag: Tag[curl_write_callback] = Tag.materializeCFuncPtr4[CString, size_t, size_t, Ptr[Byte], size_t]
    inline def apply(inline o: CFuncPtr4[CString, size_t, size_t, Ptr[Byte], size_t]): curl_write_callback = o

  opaque type curl_xferinfo_callback = CFuncPtr5[Ptr[Byte], curl_off_t, curl_off_t, curl_off_t, curl_off_t, CInt]
  object curl_xferinfo_callback: 
    given _tag: Tag[curl_xferinfo_callback] = Tag.materializeCFuncPtr5[Ptr[Byte], curl_off_t, curl_off_t, curl_off_t, curl_off_t, CInt]
    inline def apply(inline o: CFuncPtr5[Ptr[Byte], curl_off_t, curl_off_t, curl_off_t, curl_off_t, CInt]): curl_xferinfo_callback = o

  type daddr_t = int32_t
  object daddr_t: 
    given _tag: Tag[daddr_t] = int32_t._tag

  type dev_t = __darwin_dev_t
  object dev_t: 
    given _tag: Tag[dev_t] = __darwin_dev_t._tag

  opaque type errno_t = CInt
  object errno_t: 
    given _tag: Tag[errno_t] = Tag.Int
    inline def apply(inline o: CInt): errno_t = o

  type fd_mask = __int32_t
  object fd_mask: 
    given _tag: Tag[fd_mask] = __int32_t._tag

  type fixpt_t = u_int32_t
  object fixpt_t: 
    given _tag: Tag[fixpt_t] = u_int32_t._tag

  type fpos_t = __darwin_off_t
  object fpos_t: 
    given _tag: Tag[fpos_t] = __darwin_off_t._tag

  type fsblkcnt_t = __darwin_fsblkcnt_t
  object fsblkcnt_t: 
    given _tag: Tag[fsblkcnt_t] = __darwin_fsblkcnt_t._tag

  type fsfilcnt_t = __darwin_fsfilcnt_t
  object fsfilcnt_t: 
    given _tag: Tag[fsfilcnt_t] = __darwin_fsfilcnt_t._tag

  type gid_t = __darwin_gid_t
  object gid_t: 
    given _tag: Tag[gid_t] = __darwin_gid_t._tag

  type id_t = __darwin_id_t
  object id_t: 
    given _tag: Tag[id_t] = __darwin_id_t._tag

  type in_addr_t = __uint32_t
  object in_addr_t: 
    given _tag: Tag[in_addr_t] = __uint32_t._tag

  type in_port_t = __uint16_t
  object in_port_t: 
    given _tag: Tag[in_port_t] = __uint16_t._tag

  type ino64_t = __darwin_ino64_t
  object ino64_t: 
    given _tag: Tag[ino64_t] = __darwin_ino64_t._tag

  type ino_t = __darwin_ino_t
  object ino_t: 
    given _tag: Tag[ino_t] = __darwin_ino_t._tag

  opaque type int16_t = CShort
  object int16_t: 
    given _tag: Tag[int16_t] = Tag.Short
    inline def apply(inline o: CShort): int16_t = o

  opaque type int32_t = CInt
  object int32_t: 
    given _tag: Tag[int32_t] = Tag.Int
    inline def apply(inline o: CInt): int32_t = o

  opaque type int64_t = CLongLong
  object int64_t: 
    given _tag: Tag[int64_t] = Tag.Long
    inline def apply(inline o: CLongLong): int64_t = o

  opaque type int8_t = CChar
  object int8_t: 
    given _tag: Tag[int8_t] = Tag.Byte
    inline def apply(inline o: CChar): int8_t = o

  type int_fast16_t = int16_t
  object int_fast16_t: 
    given _tag: Tag[int_fast16_t] = int16_t._tag

  type int_fast32_t = int32_t
  object int_fast32_t: 
    given _tag: Tag[int_fast32_t] = int32_t._tag

  type int_fast64_t = int64_t
  object int_fast64_t: 
    given _tag: Tag[int_fast64_t] = int64_t._tag

  type int_fast8_t = int8_t
  object int_fast8_t: 
    given _tag: Tag[int_fast8_t] = int8_t._tag

  type int_least16_t = int16_t
  object int_least16_t: 
    given _tag: Tag[int_least16_t] = int16_t._tag

  type int_least32_t = int32_t
  object int_least32_t: 
    given _tag: Tag[int_least32_t] = int32_t._tag

  type int_least64_t = int64_t
  object int_least64_t: 
    given _tag: Tag[int_least64_t] = int64_t._tag

  type int_least8_t = int8_t
  object int_least8_t: 
    given _tag: Tag[int_least8_t] = int8_t._tag

  opaque type intmax_t = CLongInt
  object intmax_t: 
    given _tag: Tag[intmax_t] = Tag.Long
    inline def apply(inline o: CLongInt): intmax_t = o

  type intptr_t = __darwin_intptr_t
  object intptr_t: 
    given _tag: Tag[intptr_t] = __darwin_intptr_t._tag

  type key_t = __int32_t
  object key_t: 
    given _tag: Tag[key_t] = __int32_t._tag

  type mode_t = __darwin_mode_t
  object mode_t: 
    given _tag: Tag[mode_t] = __darwin_mode_t._tag

  type nlink_t = __uint16_t
  object nlink_t: 
    given _tag: Tag[nlink_t] = __uint16_t._tag

  type off_t = __darwin_off_t
  object off_t: 
    given _tag: Tag[off_t] = __darwin_off_t._tag

  type pid_t = __darwin_pid_t
  object pid_t: 
    given _tag: Tag[pid_t] = __darwin_pid_t._tag

  type pthread_attr_t = __darwin_pthread_attr_t
  object pthread_attr_t: 
    given _tag: Tag[pthread_attr_t] = __darwin_pthread_attr_t._tag

  type pthread_cond_t = __darwin_pthread_cond_t
  object pthread_cond_t: 
    given _tag: Tag[pthread_cond_t] = __darwin_pthread_cond_t._tag

  type pthread_condattr_t = __darwin_pthread_condattr_t
  object pthread_condattr_t: 
    given _tag: Tag[pthread_condattr_t] = __darwin_pthread_condattr_t._tag

  type pthread_key_t = __darwin_pthread_key_t
  object pthread_key_t: 
    given _tag: Tag[pthread_key_t] = __darwin_pthread_key_t._tag

  type pthread_mutex_t = __darwin_pthread_mutex_t
  object pthread_mutex_t: 
    given _tag: Tag[pthread_mutex_t] = __darwin_pthread_mutex_t._tag

  type pthread_mutexattr_t = __darwin_pthread_mutexattr_t
  object pthread_mutexattr_t: 
    given _tag: Tag[pthread_mutexattr_t] = __darwin_pthread_mutexattr_t._tag

  type pthread_once_t = __darwin_pthread_once_t
  object pthread_once_t: 
    given _tag: Tag[pthread_once_t] = __darwin_pthread_once_t._tag

  type pthread_rwlock_t = __darwin_pthread_rwlock_t
  object pthread_rwlock_t: 
    given _tag: Tag[pthread_rwlock_t] = __darwin_pthread_rwlock_t._tag

  type pthread_rwlockattr_t = __darwin_pthread_rwlockattr_t
  object pthread_rwlockattr_t: 
    given _tag: Tag[pthread_rwlockattr_t] = __darwin_pthread_rwlockattr_t._tag

  type pthread_t = __darwin_pthread_t
  object pthread_t: 
    given _tag: Tag[pthread_t] = __darwin_pthread_t._tag

  opaque type qaddr_t = Ptr[quad_t]
  object qaddr_t: 
    given _tag: Tag[qaddr_t] = Tag.Ptr[quad_t](quad_t._tag)
    inline def apply(inline o: Ptr[quad_t]): qaddr_t = o

  type quad_t = int64_t
  object quad_t: 
    given _tag: Tag[quad_t] = int64_t._tag

  type register_t = int64_t
  object register_t: 
    given _tag: Tag[register_t] = int64_t._tag

  type rsize_t = __darwin_size_t
  object rsize_t: 
    given _tag: Tag[rsize_t] = __darwin_size_t._tag

  type sa_family_t = __uint8_t
  object sa_family_t: 
    given _tag: Tag[sa_family_t] = __uint8_t._tag

  type sae_associd_t = __uint32_t
  object sae_associd_t: 
    given _tag: Tag[sae_associd_t] = __uint32_t._tag

  type sae_connid_t = __uint32_t
  object sae_connid_t: 
    given _tag: Tag[sae_connid_t] = __uint32_t._tag

  type segsz_t = int32_t
  object segsz_t: 
    given _tag: Tag[segsz_t] = int32_t._tag

  type size_t = __darwin_size_t
  object size_t: 
    given _tag: Tag[size_t] = __darwin_size_t._tag

  type socklen_t = __darwin_socklen_t
  object socklen_t: 
    given _tag: Tag[socklen_t] = __darwin_socklen_t._tag

  type ssize_t = __darwin_ssize_t
  object ssize_t: 
    given _tag: Tag[ssize_t] = __darwin_ssize_t._tag

  type suseconds_t = __darwin_suseconds_t
  object suseconds_t: 
    given _tag: Tag[suseconds_t] = __darwin_suseconds_t._tag

  type swblk_t = int32_t
  object swblk_t: 
    given _tag: Tag[swblk_t] = int32_t._tag

  type syscall_arg_t = u_int64_t
  object syscall_arg_t: 
    given _tag: Tag[syscall_arg_t] = u_int64_t._tag

  type time_t = __darwin_time_t
  object time_t: 
    given _tag: Tag[time_t] = __darwin_time_t._tag

  opaque type u_char = CUnsignedChar
  object u_char: 
    given _tag: Tag[u_char] = Tag.UByte
    inline def apply(inline o: CUnsignedChar): u_char = o

  opaque type u_int = CUnsignedInt
  object u_int: 
    given _tag: Tag[u_int] = Tag.UInt
    inline def apply(inline o: CUnsignedInt): u_int = o

  opaque type u_int16_t = CUnsignedShort
  object u_int16_t: 
    given _tag: Tag[u_int16_t] = Tag.UShort
    inline def apply(inline o: CUnsignedShort): u_int16_t = o

  opaque type u_int32_t = CUnsignedInt
  object u_int32_t: 
    given _tag: Tag[u_int32_t] = Tag.UInt
    inline def apply(inline o: CUnsignedInt): u_int32_t = o

  opaque type u_int64_t = CUnsignedLongLong
  object u_int64_t: 
    given _tag: Tag[u_int64_t] = Tag.ULong
    inline def apply(inline o: CUnsignedLongLong): u_int64_t = o

  opaque type u_int8_t = CUnsignedChar
  object u_int8_t: 
    given _tag: Tag[u_int8_t] = Tag.UByte
    inline def apply(inline o: CUnsignedChar): u_int8_t = o

  opaque type u_long = CUnsignedLongInt
  object u_long: 
    given _tag: Tag[u_long] = Tag.ULong
    inline def apply(inline o: CUnsignedLongInt): u_long = o

  type u_quad_t = u_int64_t
  object u_quad_t: 
    given _tag: Tag[u_quad_t] = u_int64_t._tag

  opaque type u_short = CUnsignedShort
  object u_short: 
    given _tag: Tag[u_short] = Tag.UShort
    inline def apply(inline o: CUnsignedShort): u_short = o

  type uid_t = __darwin_uid_t
  object uid_t: 
    given _tag: Tag[uid_t] = __darwin_uid_t._tag

  opaque type uint = CUnsignedInt
  object uint: 
    given _tag: Tag[uint] = Tag.UInt
    inline def apply(inline o: CUnsignedInt): uint = o

  opaque type uint16_t = CUnsignedShort
  object uint16_t: 
    given _tag: Tag[uint16_t] = Tag.UShort
    inline def apply(inline o: CUnsignedShort): uint16_t = o

  opaque type uint32_t = CUnsignedInt
  object uint32_t: 
    given _tag: Tag[uint32_t] = Tag.UInt
    inline def apply(inline o: CUnsignedInt): uint32_t = o

  opaque type uint64_t = CUnsignedLongLong
  object uint64_t: 
    given _tag: Tag[uint64_t] = Tag.ULong
    inline def apply(inline o: CUnsignedLongLong): uint64_t = o

  opaque type uint8_t = CUnsignedChar
  object uint8_t: 
    given _tag: Tag[uint8_t] = Tag.UByte
    inline def apply(inline o: CUnsignedChar): uint8_t = o

  type uint_fast16_t = uint16_t
  object uint_fast16_t: 
    given _tag: Tag[uint_fast16_t] = uint16_t._tag

  type uint_fast32_t = uint32_t
  object uint_fast32_t: 
    given _tag: Tag[uint_fast32_t] = uint32_t._tag

  type uint_fast64_t = uint64_t
  object uint_fast64_t: 
    given _tag: Tag[uint_fast64_t] = uint64_t._tag

  type uint_fast8_t = uint8_t
  object uint_fast8_t: 
    given _tag: Tag[uint_fast8_t] = uint8_t._tag

  type uint_least16_t = uint16_t
  object uint_least16_t: 
    given _tag: Tag[uint_least16_t] = uint16_t._tag

  type uint_least32_t = uint32_t
  object uint_least32_t: 
    given _tag: Tag[uint_least32_t] = uint32_t._tag

  type uint_least64_t = uint64_t
  object uint_least64_t: 
    given _tag: Tag[uint_least64_t] = uint64_t._tag

  type uint_least8_t = uint8_t
  object uint_least8_t: 
    given _tag: Tag[uint_least8_t] = uint8_t._tag

  opaque type uintmax_t = CUnsignedLongInt
  object uintmax_t: 
    given _tag: Tag[uintmax_t] = Tag.ULong
    inline def apply(inline o: CUnsignedLongInt): uintmax_t = o

  opaque type uintptr_t = CUnsignedLongInt
  object uintptr_t: 
    given _tag: Tag[uintptr_t] = Tag.ULong
    inline def apply(inline o: CUnsignedLongInt): uintptr_t = o

  type useconds_t = __darwin_useconds_t
  object useconds_t: 
    given _tag: Tag[useconds_t] = __darwin_useconds_t._tag

  type user_addr_t = u_int64_t
  object user_addr_t: 
    given _tag: Tag[user_addr_t] = u_int64_t._tag

  type user_long_t = int64_t
  object user_long_t: 
    given _tag: Tag[user_long_t] = int64_t._tag

  type user_off_t = int64_t
  object user_off_t: 
    given _tag: Tag[user_off_t] = int64_t._tag

  type user_size_t = u_int64_t
  object user_size_t: 
    given _tag: Tag[user_size_t] = u_int64_t._tag

  type user_ssize_t = int64_t
  object user_ssize_t: 
    given _tag: Tag[user_ssize_t] = int64_t._tag

  type user_time_t = int64_t
  object user_time_t: 
    given _tag: Tag[user_time_t] = int64_t._tag

  type user_ulong_t = u_int64_t
  object user_ulong_t: 
    given _tag: Tag[user_ulong_t] = u_int64_t._tag

  opaque type ushort = CUnsignedShort
  object ushort: 
    given _tag: Tag[ushort] = Tag.UShort
    inline def apply(inline o: CUnsignedShort): ushort = o

  type va_list = __darwin_va_list
  object va_list: 
    given _tag: Tag[va_list] = __darwin_va_list._tag
  opaque type CURLMsg = CStruct3[CURLMSG, Ptr[CURL], CURLMsg.Union0]
  object CURLMsg:
    opaque type Union0 = CArray[Byte, Nat._8]
    object Union0:
      given _tag: Tag[Union0] = Tag.CArray[CChar, Nat._8](Tag.Byte, Tag.Nat8)
      extension (struct: Union0)
        def whatever: Ptr[Byte] = !struct.at(0).asInstanceOf[Ptr[Ptr[Byte]]]
        def result: CURLcode = !struct.at(0).asInstanceOf[Ptr[CURLcode]]
    given _tag: Tag[CURLMsg] = Tag.materializeCStruct3Tag[CURLMSG, Ptr[CURL], CURLMsg.Union0]
    def apply()(using Zone): Ptr[CURLMsg] = scala.scalanative.unsafe.alloc[CURLMsg](1)
    def apply(msg: CURLMSG, easy_handle: Ptr[CURL], data: CURLMsg.Union0)(using Zone): Ptr[CURLMsg] = 
      val ____ptr = apply()
      (!____ptr).msg = msg
      (!____ptr).easy_handle = easy_handle
      (!____ptr).data = data
      ____ptr
    extension (struct: CURLMsg)
      def msg: CURLMSG = struct._1
      def msg_=(value: CURLMSG): Unit = !struct.at1 = value
      def easy_handle: Ptr[CURL] = struct._2
      def easy_handle_=(value: Ptr[CURL]): Unit = !struct.at2 = value
      def data: CURLMsg.Union0 = struct._3
      def data_=(value: CURLMsg.Union0): Unit = !struct.at3 = value

  opaque type CURLU = CStruct0
  object CURLU:
    given _tag: Tag[CURLU] = Tag.materializeCStruct0Tag

  opaque type Curl_URL = CStruct0
  object Curl_URL:
    given _tag: Tag[Curl_URL] = Tag.materializeCStruct0Tag

  opaque type FILE = CStruct20[Ptr[CUnsignedChar], CInt, CInt, CShort, CShort, __sbuf, CInt, Ptr[Byte], CFuncPtr1[Ptr[Byte], CInt], CFuncPtr3[Ptr[Byte], CString, CInt, CInt], CFuncPtr3[Ptr[Byte], fpos_t, CInt, fpos_t], CFuncPtr3[Ptr[Byte], CString, CInt, CInt], __sbuf, Ptr[__sFILEX], CInt, CArray[CUnsignedChar, Nat._3], CArray[CUnsignedChar, Nat._1], __sbuf, CInt, fpos_t]
  object FILE:
    given _tag: Tag[FILE] = Tag.materializeCStruct20Tag[Ptr[CUnsignedChar], CInt, CInt, CShort, CShort, __sbuf, CInt, Ptr[Byte], CFuncPtr1[Ptr[Byte], CInt], CFuncPtr3[Ptr[Byte], CString, CInt, CInt], CFuncPtr3[Ptr[Byte], fpos_t, CInt, fpos_t], CFuncPtr3[Ptr[Byte], CString, CInt, CInt], __sbuf, Ptr[__sFILEX], CInt, CArray[CUnsignedChar, Nat._3], CArray[CUnsignedChar, Nat._1], __sbuf, CInt, fpos_t]
    def apply()(using Zone): Ptr[FILE] = scala.scalanative.unsafe.alloc[FILE](1)
    def apply(_p: Ptr[CUnsignedChar], _r: CInt, _w: CInt, _flags: CShort, _file: CShort, _bf: __sbuf, _lbfsize: CInt, _cookie: Ptr[Byte], _close: CFuncPtr1[Ptr[Byte], CInt], _read: CFuncPtr3[Ptr[Byte], CString, CInt, CInt], _seek: CFuncPtr3[Ptr[Byte], fpos_t, CInt, fpos_t], _write: CFuncPtr3[Ptr[Byte], CString, CInt, CInt], _ub: __sbuf, _extra: Ptr[__sFILEX], _ur: CInt, _ubuf: CArray[CUnsignedChar, Nat._3], _nbuf: CArray[CUnsignedChar, Nat._1], _lb: __sbuf, _blksize: CInt, _offset: fpos_t)(using Zone): Ptr[FILE] = 
      val ____ptr = apply()
      (!____ptr)._p = _p
      (!____ptr)._r = _r
      (!____ptr)._w = _w
      (!____ptr)._flags = _flags
      (!____ptr)._file = _file
      (!____ptr)._bf = _bf
      (!____ptr)._lbfsize = _lbfsize
      (!____ptr)._cookie = _cookie
      (!____ptr)._close = _close
      (!____ptr)._read = _read
      (!____ptr)._seek = _seek
      (!____ptr)._write = _write
      (!____ptr)._ub = _ub
      (!____ptr)._extra = _extra
      (!____ptr)._ur = _ur
      (!____ptr)._ubuf = _ubuf
      (!____ptr)._nbuf = _nbuf
      (!____ptr)._lb = _lb
      (!____ptr)._blksize = _blksize
      (!____ptr)._offset = _offset
      ____ptr
    extension (struct: FILE)
      def _p: Ptr[CUnsignedChar] = struct._1
      def _p_=(value: Ptr[CUnsignedChar]): Unit = !struct.at1 = value
      def _r: CInt = struct._2
      def _r_=(value: CInt): Unit = !struct.at2 = value
      def _w: CInt = struct._3
      def _w_=(value: CInt): Unit = !struct.at3 = value
      def _flags: CShort = struct._4
      def _flags_=(value: CShort): Unit = !struct.at4 = value
      def _file: CShort = struct._5
      def _file_=(value: CShort): Unit = !struct.at5 = value
      def _bf: __sbuf = struct._6
      def _bf_=(value: __sbuf): Unit = !struct.at6 = value
      def _lbfsize: CInt = struct._7
      def _lbfsize_=(value: CInt): Unit = !struct.at7 = value
      def _cookie: Ptr[Byte] = struct._8
      def _cookie_=(value: Ptr[Byte]): Unit = !struct.at8 = value
      def _close: CFuncPtr1[Ptr[Byte], CInt] = struct._9
      def _close_=(value: CFuncPtr1[Ptr[Byte], CInt]): Unit = !struct.at9 = value
      def _read: CFuncPtr3[Ptr[Byte], CString, CInt, CInt] = struct._10
      def _read_=(value: CFuncPtr3[Ptr[Byte], CString, CInt, CInt]): Unit = !struct.at10 = value
      def _seek: CFuncPtr3[Ptr[Byte], fpos_t, CInt, fpos_t] = struct._11
      def _seek_=(value: CFuncPtr3[Ptr[Byte], fpos_t, CInt, fpos_t]): Unit = !struct.at11 = value
      def _write: CFuncPtr3[Ptr[Byte], CString, CInt, CInt] = struct._12
      def _write_=(value: CFuncPtr3[Ptr[Byte], CString, CInt, CInt]): Unit = !struct.at12 = value
      def _ub: __sbuf = struct._13
      def _ub_=(value: __sbuf): Unit = !struct.at13 = value
      def _extra: Ptr[__sFILEX] = struct._14
      def _extra_=(value: Ptr[__sFILEX]): Unit = !struct.at14 = value
      def _ur: CInt = struct._15
      def _ur_=(value: CInt): Unit = !struct.at15 = value
      def _ubuf: CArray[CUnsignedChar, Nat._3] = struct._16
      def _ubuf_=(value: CArray[CUnsignedChar, Nat._3]): Unit = !struct.at16 = value
      def _nbuf: CArray[CUnsignedChar, Nat._1] = struct._17
      def _nbuf_=(value: CArray[CUnsignedChar, Nat._1]): Unit = !struct.at17 = value
      def _lb: __sbuf = struct._18
      def _lb_=(value: __sbuf): Unit = !struct.at18 = value
      def _blksize: CInt = struct._19
      def _blksize_=(value: CInt): Unit = !struct.at19 = value
      def _offset: fpos_t = struct._20
      def _offset_=(value: fpos_t): Unit = !struct.at20 = value

  opaque type _OSUnalignedU16 = CStruct1[uint16_t]
  object _OSUnalignedU16:
    given _tag: Tag[_OSUnalignedU16] = Tag.materializeCStruct1Tag[uint16_t]
    def apply()(using Zone): Ptr[_OSUnalignedU16] = scala.scalanative.unsafe.alloc[_OSUnalignedU16](1)
    def apply(__val: uint16_t)(using Zone): Ptr[_OSUnalignedU16] = 
      val ____ptr = apply()
      (!____ptr).__val = __val
      ____ptr
    extension (struct: _OSUnalignedU16)
      def __val: uint16_t = struct._1
      def __val_=(value: uint16_t): Unit = !struct.at1 = value

  opaque type _OSUnalignedU32 = CStruct1[uint32_t]
  object _OSUnalignedU32:
    given _tag: Tag[_OSUnalignedU32] = Tag.materializeCStruct1Tag[uint32_t]
    def apply()(using Zone): Ptr[_OSUnalignedU32] = scala.scalanative.unsafe.alloc[_OSUnalignedU32](1)
    def apply(__val: uint32_t)(using Zone): Ptr[_OSUnalignedU32] = 
      val ____ptr = apply()
      (!____ptr).__val = __val
      ____ptr
    extension (struct: _OSUnalignedU32)
      def __val: uint32_t = struct._1
      def __val_=(value: uint32_t): Unit = !struct.at1 = value

  opaque type _OSUnalignedU64 = CStruct1[uint64_t]
  object _OSUnalignedU64:
    given _tag: Tag[_OSUnalignedU64] = Tag.materializeCStruct1Tag[uint64_t]
    def apply()(using Zone): Ptr[_OSUnalignedU64] = scala.scalanative.unsafe.alloc[_OSUnalignedU64](1)
    def apply(__val: uint64_t)(using Zone): Ptr[_OSUnalignedU64] = 
      val ____ptr = apply()
      (!____ptr).__val = __val
      ____ptr
    extension (struct: _OSUnalignedU64)
      def __val: uint64_t = struct._1
      def __val_=(value: uint64_t): Unit = !struct.at1 = value

  opaque type __darwin_pthread_attr_t = CStruct2[CLongInt, CArray[CChar, Nat.Digit2[Nat._5, Nat._6]]]
  object __darwin_pthread_attr_t:
    given _tag: Tag[__darwin_pthread_attr_t] = Tag.materializeCStruct2Tag[CLongInt, CArray[CChar, Nat.Digit2[Nat._5, Nat._6]]]
    def apply()(using Zone): Ptr[__darwin_pthread_attr_t] = scala.scalanative.unsafe.alloc[__darwin_pthread_attr_t](1)
    def apply(__sig: CLongInt, __opaque: CArray[CChar, Nat.Digit2[Nat._5, Nat._6]])(using Zone): Ptr[__darwin_pthread_attr_t] = 
      val ____ptr = apply()
      (!____ptr).__sig = __sig
      (!____ptr).__opaque = __opaque
      ____ptr
    extension (struct: __darwin_pthread_attr_t)
      def __sig: CLongInt = struct._1
      def __sig_=(value: CLongInt): Unit = !struct.at1 = value
      def __opaque: CArray[CChar, Nat.Digit2[Nat._5, Nat._6]] = struct._2
      def __opaque_=(value: CArray[CChar, Nat.Digit2[Nat._5, Nat._6]]): Unit = !struct.at2 = value

  opaque type __darwin_pthread_cond_t = CStruct2[CLongInt, CArray[CChar, Nat.Digit2[Nat._4, Nat._0]]]
  object __darwin_pthread_cond_t:
    given _tag: Tag[__darwin_pthread_cond_t] = Tag.materializeCStruct2Tag[CLongInt, CArray[CChar, Nat.Digit2[Nat._4, Nat._0]]]
    def apply()(using Zone): Ptr[__darwin_pthread_cond_t] = scala.scalanative.unsafe.alloc[__darwin_pthread_cond_t](1)
    def apply(__sig: CLongInt, __opaque: CArray[CChar, Nat.Digit2[Nat._4, Nat._0]])(using Zone): Ptr[__darwin_pthread_cond_t] = 
      val ____ptr = apply()
      (!____ptr).__sig = __sig
      (!____ptr).__opaque = __opaque
      ____ptr
    extension (struct: __darwin_pthread_cond_t)
      def __sig: CLongInt = struct._1
      def __sig_=(value: CLongInt): Unit = !struct.at1 = value
      def __opaque: CArray[CChar, Nat.Digit2[Nat._4, Nat._0]] = struct._2
      def __opaque_=(value: CArray[CChar, Nat.Digit2[Nat._4, Nat._0]]): Unit = !struct.at2 = value

  opaque type __darwin_pthread_condattr_t = CStruct2[CLongInt, CArray[CChar, Nat._8]]
  object __darwin_pthread_condattr_t:
    given _tag: Tag[__darwin_pthread_condattr_t] = Tag.materializeCStruct2Tag[CLongInt, CArray[CChar, Nat._8]]
    def apply()(using Zone): Ptr[__darwin_pthread_condattr_t] = scala.scalanative.unsafe.alloc[__darwin_pthread_condattr_t](1)
    def apply(__sig: CLongInt, __opaque: CArray[CChar, Nat._8])(using Zone): Ptr[__darwin_pthread_condattr_t] = 
      val ____ptr = apply()
      (!____ptr).__sig = __sig
      (!____ptr).__opaque = __opaque
      ____ptr
    extension (struct: __darwin_pthread_condattr_t)
      def __sig: CLongInt = struct._1
      def __sig_=(value: CLongInt): Unit = !struct.at1 = value
      def __opaque: CArray[CChar, Nat._8] = struct._2
      def __opaque_=(value: CArray[CChar, Nat._8]): Unit = !struct.at2 = value

  opaque type __darwin_pthread_handler_rec = CStruct3[CFuncPtr1[Ptr[Byte], Unit], Ptr[Byte], Ptr[Byte]]
  object __darwin_pthread_handler_rec:
    given _tag: Tag[__darwin_pthread_handler_rec] = Tag.materializeCStruct3Tag[CFuncPtr1[Ptr[Byte], Unit], Ptr[Byte], Ptr[Byte]]
    def apply()(using Zone): Ptr[__darwin_pthread_handler_rec] = scala.scalanative.unsafe.alloc[__darwin_pthread_handler_rec](1)
    def apply(__routine: CFuncPtr1[Ptr[Byte], Unit], __arg: Ptr[Byte], __next: Ptr[__darwin_pthread_handler_rec])(using Zone): Ptr[__darwin_pthread_handler_rec] = 
      val ____ptr = apply()
      (!____ptr).__routine = __routine
      (!____ptr).__arg = __arg
      (!____ptr).__next = __next
      ____ptr
    extension (struct: __darwin_pthread_handler_rec)
      def __routine: CFuncPtr1[Ptr[Byte], Unit] = struct._1
      def __routine_=(value: CFuncPtr1[Ptr[Byte], Unit]): Unit = !struct.at1 = value
      def __arg: Ptr[Byte] = struct._2
      def __arg_=(value: Ptr[Byte]): Unit = !struct.at2 = value
      def __next: Ptr[__darwin_pthread_handler_rec] = struct._3.asInstanceOf[Ptr[__darwin_pthread_handler_rec]]
      def __next_=(value: Ptr[__darwin_pthread_handler_rec]): Unit = !struct.at3 = value.asInstanceOf[Ptr[Byte]]

  opaque type __darwin_pthread_mutex_t = CStruct2[CLongInt, CArray[CChar, Nat.Digit2[Nat._5, Nat._6]]]
  object __darwin_pthread_mutex_t:
    given _tag: Tag[__darwin_pthread_mutex_t] = Tag.materializeCStruct2Tag[CLongInt, CArray[CChar, Nat.Digit2[Nat._5, Nat._6]]]
    def apply()(using Zone): Ptr[__darwin_pthread_mutex_t] = scala.scalanative.unsafe.alloc[__darwin_pthread_mutex_t](1)
    def apply(__sig: CLongInt, __opaque: CArray[CChar, Nat.Digit2[Nat._5, Nat._6]])(using Zone): Ptr[__darwin_pthread_mutex_t] = 
      val ____ptr = apply()
      (!____ptr).__sig = __sig
      (!____ptr).__opaque = __opaque
      ____ptr
    extension (struct: __darwin_pthread_mutex_t)
      def __sig: CLongInt = struct._1
      def __sig_=(value: CLongInt): Unit = !struct.at1 = value
      def __opaque: CArray[CChar, Nat.Digit2[Nat._5, Nat._6]] = struct._2
      def __opaque_=(value: CArray[CChar, Nat.Digit2[Nat._5, Nat._6]]): Unit = !struct.at2 = value

  opaque type __darwin_pthread_mutexattr_t = CStruct2[CLongInt, CArray[CChar, Nat._8]]
  object __darwin_pthread_mutexattr_t:
    given _tag: Tag[__darwin_pthread_mutexattr_t] = Tag.materializeCStruct2Tag[CLongInt, CArray[CChar, Nat._8]]
    def apply()(using Zone): Ptr[__darwin_pthread_mutexattr_t] = scala.scalanative.unsafe.alloc[__darwin_pthread_mutexattr_t](1)
    def apply(__sig: CLongInt, __opaque: CArray[CChar, Nat._8])(using Zone): Ptr[__darwin_pthread_mutexattr_t] = 
      val ____ptr = apply()
      (!____ptr).__sig = __sig
      (!____ptr).__opaque = __opaque
      ____ptr
    extension (struct: __darwin_pthread_mutexattr_t)
      def __sig: CLongInt = struct._1
      def __sig_=(value: CLongInt): Unit = !struct.at1 = value
      def __opaque: CArray[CChar, Nat._8] = struct._2
      def __opaque_=(value: CArray[CChar, Nat._8]): Unit = !struct.at2 = value

  opaque type __darwin_pthread_once_t = CStruct2[CLongInt, CArray[CChar, Nat._8]]
  object __darwin_pthread_once_t:
    given _tag: Tag[__darwin_pthread_once_t] = Tag.materializeCStruct2Tag[CLongInt, CArray[CChar, Nat._8]]
    def apply()(using Zone): Ptr[__darwin_pthread_once_t] = scala.scalanative.unsafe.alloc[__darwin_pthread_once_t](1)
    def apply(__sig: CLongInt, __opaque: CArray[CChar, Nat._8])(using Zone): Ptr[__darwin_pthread_once_t] = 
      val ____ptr = apply()
      (!____ptr).__sig = __sig
      (!____ptr).__opaque = __opaque
      ____ptr
    extension (struct: __darwin_pthread_once_t)
      def __sig: CLongInt = struct._1
      def __sig_=(value: CLongInt): Unit = !struct.at1 = value
      def __opaque: CArray[CChar, Nat._8] = struct._2
      def __opaque_=(value: CArray[CChar, Nat._8]): Unit = !struct.at2 = value

  opaque type __darwin_pthread_rwlock_t = CStruct2[CLongInt, CArray[CChar, Nat.Digit3[Nat._1, Nat._9, Nat._2]]]
  object __darwin_pthread_rwlock_t:
    given _tag: Tag[__darwin_pthread_rwlock_t] = Tag.materializeCStruct2Tag[CLongInt, CArray[CChar, Nat.Digit3[Nat._1, Nat._9, Nat._2]]]
    def apply()(using Zone): Ptr[__darwin_pthread_rwlock_t] = scala.scalanative.unsafe.alloc[__darwin_pthread_rwlock_t](1)
    def apply(__sig: CLongInt, __opaque: CArray[CChar, Nat.Digit3[Nat._1, Nat._9, Nat._2]])(using Zone): Ptr[__darwin_pthread_rwlock_t] = 
      val ____ptr = apply()
      (!____ptr).__sig = __sig
      (!____ptr).__opaque = __opaque
      ____ptr
    extension (struct: __darwin_pthread_rwlock_t)
      def __sig: CLongInt = struct._1
      def __sig_=(value: CLongInt): Unit = !struct.at1 = value
      def __opaque: CArray[CChar, Nat.Digit3[Nat._1, Nat._9, Nat._2]] = struct._2
      def __opaque_=(value: CArray[CChar, Nat.Digit3[Nat._1, Nat._9, Nat._2]]): Unit = !struct.at2 = value

  opaque type __darwin_pthread_rwlockattr_t = CStruct2[CLongInt, CArray[CChar, Nat.Digit2[Nat._1, Nat._6]]]
  object __darwin_pthread_rwlockattr_t:
    given _tag: Tag[__darwin_pthread_rwlockattr_t] = Tag.materializeCStruct2Tag[CLongInt, CArray[CChar, Nat.Digit2[Nat._1, Nat._6]]]
    def apply()(using Zone): Ptr[__darwin_pthread_rwlockattr_t] = scala.scalanative.unsafe.alloc[__darwin_pthread_rwlockattr_t](1)
    def apply(__sig: CLongInt, __opaque: CArray[CChar, Nat.Digit2[Nat._1, Nat._6]])(using Zone): Ptr[__darwin_pthread_rwlockattr_t] = 
      val ____ptr = apply()
      (!____ptr).__sig = __sig
      (!____ptr).__opaque = __opaque
      ____ptr
    extension (struct: __darwin_pthread_rwlockattr_t)
      def __sig: CLongInt = struct._1
      def __sig_=(value: CLongInt): Unit = !struct.at1 = value
      def __opaque: CArray[CChar, Nat.Digit2[Nat._1, Nat._6]] = struct._2
      def __opaque_=(value: CArray[CChar, Nat.Digit2[Nat._1, Nat._6]]): Unit = !struct.at2 = value

  opaque type __sFILE = CStruct20[Ptr[CUnsignedChar], CInt, CInt, CShort, CShort, __sbuf, CInt, Ptr[Byte], CFuncPtr1[Ptr[Byte], CInt], CFuncPtr3[Ptr[Byte], CString, CInt, CInt], CFuncPtr3[Ptr[Byte], fpos_t, CInt, fpos_t], CFuncPtr3[Ptr[Byte], CString, CInt, CInt], __sbuf, Ptr[__sFILEX], CInt, CArray[CUnsignedChar, Nat._3], CArray[CUnsignedChar, Nat._1], __sbuf, CInt, fpos_t]
  object __sFILE:
    given _tag: Tag[__sFILE] = Tag.materializeCStruct20Tag[Ptr[CUnsignedChar], CInt, CInt, CShort, CShort, __sbuf, CInt, Ptr[Byte], CFuncPtr1[Ptr[Byte], CInt], CFuncPtr3[Ptr[Byte], CString, CInt, CInt], CFuncPtr3[Ptr[Byte], fpos_t, CInt, fpos_t], CFuncPtr3[Ptr[Byte], CString, CInt, CInt], __sbuf, Ptr[__sFILEX], CInt, CArray[CUnsignedChar, Nat._3], CArray[CUnsignedChar, Nat._1], __sbuf, CInt, fpos_t]
    def apply()(using Zone): Ptr[__sFILE] = scala.scalanative.unsafe.alloc[__sFILE](1)
    def apply(_p: Ptr[CUnsignedChar], _r: CInt, _w: CInt, _flags: CShort, _file: CShort, _bf: __sbuf, _lbfsize: CInt, _cookie: Ptr[Byte], _close: CFuncPtr1[Ptr[Byte], CInt], _read: CFuncPtr3[Ptr[Byte], CString, CInt, CInt], _seek: CFuncPtr3[Ptr[Byte], fpos_t, CInt, fpos_t], _write: CFuncPtr3[Ptr[Byte], CString, CInt, CInt], _ub: __sbuf, _extra: Ptr[__sFILEX], _ur: CInt, _ubuf: CArray[CUnsignedChar, Nat._3], _nbuf: CArray[CUnsignedChar, Nat._1], _lb: __sbuf, _blksize: CInt, _offset: fpos_t)(using Zone): Ptr[__sFILE] = 
      val ____ptr = apply()
      (!____ptr)._p = _p
      (!____ptr)._r = _r
      (!____ptr)._w = _w
      (!____ptr)._flags = _flags
      (!____ptr)._file = _file
      (!____ptr)._bf = _bf
      (!____ptr)._lbfsize = _lbfsize
      (!____ptr)._cookie = _cookie
      (!____ptr)._close = _close
      (!____ptr)._read = _read
      (!____ptr)._seek = _seek
      (!____ptr)._write = _write
      (!____ptr)._ub = _ub
      (!____ptr)._extra = _extra
      (!____ptr)._ur = _ur
      (!____ptr)._ubuf = _ubuf
      (!____ptr)._nbuf = _nbuf
      (!____ptr)._lb = _lb
      (!____ptr)._blksize = _blksize
      (!____ptr)._offset = _offset
      ____ptr
    extension (struct: __sFILE)
      def _p: Ptr[CUnsignedChar] = struct._1
      def _p_=(value: Ptr[CUnsignedChar]): Unit = !struct.at1 = value
      def _r: CInt = struct._2
      def _r_=(value: CInt): Unit = !struct.at2 = value
      def _w: CInt = struct._3
      def _w_=(value: CInt): Unit = !struct.at3 = value
      def _flags: CShort = struct._4
      def _flags_=(value: CShort): Unit = !struct.at4 = value
      def _file: CShort = struct._5
      def _file_=(value: CShort): Unit = !struct.at5 = value
      def _bf: __sbuf = struct._6
      def _bf_=(value: __sbuf): Unit = !struct.at6 = value
      def _lbfsize: CInt = struct._7
      def _lbfsize_=(value: CInt): Unit = !struct.at7 = value
      def _cookie: Ptr[Byte] = struct._8
      def _cookie_=(value: Ptr[Byte]): Unit = !struct.at8 = value
      def _close: CFuncPtr1[Ptr[Byte], CInt] = struct._9
      def _close_=(value: CFuncPtr1[Ptr[Byte], CInt]): Unit = !struct.at9 = value
      def _read: CFuncPtr3[Ptr[Byte], CString, CInt, CInt] = struct._10
      def _read_=(value: CFuncPtr3[Ptr[Byte], CString, CInt, CInt]): Unit = !struct.at10 = value
      def _seek: CFuncPtr3[Ptr[Byte], fpos_t, CInt, fpos_t] = struct._11
      def _seek_=(value: CFuncPtr3[Ptr[Byte], fpos_t, CInt, fpos_t]): Unit = !struct.at11 = value
      def _write: CFuncPtr3[Ptr[Byte], CString, CInt, CInt] = struct._12
      def _write_=(value: CFuncPtr3[Ptr[Byte], CString, CInt, CInt]): Unit = !struct.at12 = value
      def _ub: __sbuf = struct._13
      def _ub_=(value: __sbuf): Unit = !struct.at13 = value
      def _extra: Ptr[__sFILEX] = struct._14
      def _extra_=(value: Ptr[__sFILEX]): Unit = !struct.at14 = value
      def _ur: CInt = struct._15
      def _ur_=(value: CInt): Unit = !struct.at15 = value
      def _ubuf: CArray[CUnsignedChar, Nat._3] = struct._16
      def _ubuf_=(value: CArray[CUnsignedChar, Nat._3]): Unit = !struct.at16 = value
      def _nbuf: CArray[CUnsignedChar, Nat._1] = struct._17
      def _nbuf_=(value: CArray[CUnsignedChar, Nat._1]): Unit = !struct.at17 = value
      def _lb: __sbuf = struct._18
      def _lb_=(value: __sbuf): Unit = !struct.at18 = value
      def _blksize: CInt = struct._19
      def _blksize_=(value: CInt): Unit = !struct.at19 = value
      def _offset: fpos_t = struct._20
      def _offset_=(value: fpos_t): Unit = !struct.at20 = value

  opaque type __sFILEX = CStruct0
  object __sFILEX:
    given _tag: Tag[__sFILEX] = Tag.materializeCStruct0Tag

  opaque type __sbuf = CStruct2[Ptr[CUnsignedChar], CInt]
  object __sbuf:
    given _tag: Tag[__sbuf] = Tag.materializeCStruct2Tag[Ptr[CUnsignedChar], CInt]
    def apply()(using Zone): Ptr[__sbuf] = scala.scalanative.unsafe.alloc[__sbuf](1)
    def apply(_base: Ptr[CUnsignedChar], _size: CInt)(using Zone): Ptr[__sbuf] = 
      val ____ptr = apply()
      (!____ptr)._base = _base
      (!____ptr)._size = _size
      ____ptr
    extension (struct: __sbuf)
      def _base: Ptr[CUnsignedChar] = struct._1
      def _base_=(value: Ptr[CUnsignedChar]): Unit = !struct.at1 = value
      def _size: CInt = struct._2
      def _size_=(value: CInt): Unit = !struct.at2 = value

  opaque type _opaque_pthread_attr_t = CStruct2[CLongInt, CArray[CChar, Nat.Digit2[Nat._5, Nat._6]]]
  object _opaque_pthread_attr_t:
    given _tag: Tag[_opaque_pthread_attr_t] = Tag.materializeCStruct2Tag[CLongInt, CArray[CChar, Nat.Digit2[Nat._5, Nat._6]]]
    def apply()(using Zone): Ptr[_opaque_pthread_attr_t] = scala.scalanative.unsafe.alloc[_opaque_pthread_attr_t](1)
    def apply(__sig: CLongInt, __opaque: CArray[CChar, Nat.Digit2[Nat._5, Nat._6]])(using Zone): Ptr[_opaque_pthread_attr_t] = 
      val ____ptr = apply()
      (!____ptr).__sig = __sig
      (!____ptr).__opaque = __opaque
      ____ptr
    extension (struct: _opaque_pthread_attr_t)
      def __sig: CLongInt = struct._1
      def __sig_=(value: CLongInt): Unit = !struct.at1 = value
      def __opaque: CArray[CChar, Nat.Digit2[Nat._5, Nat._6]] = struct._2
      def __opaque_=(value: CArray[CChar, Nat.Digit2[Nat._5, Nat._6]]): Unit = !struct.at2 = value

  opaque type _opaque_pthread_cond_t = CStruct2[CLongInt, CArray[CChar, Nat.Digit2[Nat._4, Nat._0]]]
  object _opaque_pthread_cond_t:
    given _tag: Tag[_opaque_pthread_cond_t] = Tag.materializeCStruct2Tag[CLongInt, CArray[CChar, Nat.Digit2[Nat._4, Nat._0]]]
    def apply()(using Zone): Ptr[_opaque_pthread_cond_t] = scala.scalanative.unsafe.alloc[_opaque_pthread_cond_t](1)
    def apply(__sig: CLongInt, __opaque: CArray[CChar, Nat.Digit2[Nat._4, Nat._0]])(using Zone): Ptr[_opaque_pthread_cond_t] = 
      val ____ptr = apply()
      (!____ptr).__sig = __sig
      (!____ptr).__opaque = __opaque
      ____ptr
    extension (struct: _opaque_pthread_cond_t)
      def __sig: CLongInt = struct._1
      def __sig_=(value: CLongInt): Unit = !struct.at1 = value
      def __opaque: CArray[CChar, Nat.Digit2[Nat._4, Nat._0]] = struct._2
      def __opaque_=(value: CArray[CChar, Nat.Digit2[Nat._4, Nat._0]]): Unit = !struct.at2 = value

  opaque type _opaque_pthread_condattr_t = CStruct2[CLongInt, CArray[CChar, Nat._8]]
  object _opaque_pthread_condattr_t:
    given _tag: Tag[_opaque_pthread_condattr_t] = Tag.materializeCStruct2Tag[CLongInt, CArray[CChar, Nat._8]]
    def apply()(using Zone): Ptr[_opaque_pthread_condattr_t] = scala.scalanative.unsafe.alloc[_opaque_pthread_condattr_t](1)
    def apply(__sig: CLongInt, __opaque: CArray[CChar, Nat._8])(using Zone): Ptr[_opaque_pthread_condattr_t] = 
      val ____ptr = apply()
      (!____ptr).__sig = __sig
      (!____ptr).__opaque = __opaque
      ____ptr
    extension (struct: _opaque_pthread_condattr_t)
      def __sig: CLongInt = struct._1
      def __sig_=(value: CLongInt): Unit = !struct.at1 = value
      def __opaque: CArray[CChar, Nat._8] = struct._2
      def __opaque_=(value: CArray[CChar, Nat._8]): Unit = !struct.at2 = value

  opaque type _opaque_pthread_mutex_t = CStruct2[CLongInt, CArray[CChar, Nat.Digit2[Nat._5, Nat._6]]]
  object _opaque_pthread_mutex_t:
    given _tag: Tag[_opaque_pthread_mutex_t] = Tag.materializeCStruct2Tag[CLongInt, CArray[CChar, Nat.Digit2[Nat._5, Nat._6]]]
    def apply()(using Zone): Ptr[_opaque_pthread_mutex_t] = scala.scalanative.unsafe.alloc[_opaque_pthread_mutex_t](1)
    def apply(__sig: CLongInt, __opaque: CArray[CChar, Nat.Digit2[Nat._5, Nat._6]])(using Zone): Ptr[_opaque_pthread_mutex_t] = 
      val ____ptr = apply()
      (!____ptr).__sig = __sig
      (!____ptr).__opaque = __opaque
      ____ptr
    extension (struct: _opaque_pthread_mutex_t)
      def __sig: CLongInt = struct._1
      def __sig_=(value: CLongInt): Unit = !struct.at1 = value
      def __opaque: CArray[CChar, Nat.Digit2[Nat._5, Nat._6]] = struct._2
      def __opaque_=(value: CArray[CChar, Nat.Digit2[Nat._5, Nat._6]]): Unit = !struct.at2 = value

  opaque type _opaque_pthread_mutexattr_t = CStruct2[CLongInt, CArray[CChar, Nat._8]]
  object _opaque_pthread_mutexattr_t:
    given _tag: Tag[_opaque_pthread_mutexattr_t] = Tag.materializeCStruct2Tag[CLongInt, CArray[CChar, Nat._8]]
    def apply()(using Zone): Ptr[_opaque_pthread_mutexattr_t] = scala.scalanative.unsafe.alloc[_opaque_pthread_mutexattr_t](1)
    def apply(__sig: CLongInt, __opaque: CArray[CChar, Nat._8])(using Zone): Ptr[_opaque_pthread_mutexattr_t] = 
      val ____ptr = apply()
      (!____ptr).__sig = __sig
      (!____ptr).__opaque = __opaque
      ____ptr
    extension (struct: _opaque_pthread_mutexattr_t)
      def __sig: CLongInt = struct._1
      def __sig_=(value: CLongInt): Unit = !struct.at1 = value
      def __opaque: CArray[CChar, Nat._8] = struct._2
      def __opaque_=(value: CArray[CChar, Nat._8]): Unit = !struct.at2 = value

  opaque type _opaque_pthread_once_t = CStruct2[CLongInt, CArray[CChar, Nat._8]]
  object _opaque_pthread_once_t:
    given _tag: Tag[_opaque_pthread_once_t] = Tag.materializeCStruct2Tag[CLongInt, CArray[CChar, Nat._8]]
    def apply()(using Zone): Ptr[_opaque_pthread_once_t] = scala.scalanative.unsafe.alloc[_opaque_pthread_once_t](1)
    def apply(__sig: CLongInt, __opaque: CArray[CChar, Nat._8])(using Zone): Ptr[_opaque_pthread_once_t] = 
      val ____ptr = apply()
      (!____ptr).__sig = __sig
      (!____ptr).__opaque = __opaque
      ____ptr
    extension (struct: _opaque_pthread_once_t)
      def __sig: CLongInt = struct._1
      def __sig_=(value: CLongInt): Unit = !struct.at1 = value
      def __opaque: CArray[CChar, Nat._8] = struct._2
      def __opaque_=(value: CArray[CChar, Nat._8]): Unit = !struct.at2 = value

  opaque type _opaque_pthread_rwlock_t = CStruct2[CLongInt, CArray[CChar, Nat.Digit3[Nat._1, Nat._9, Nat._2]]]
  object _opaque_pthread_rwlock_t:
    given _tag: Tag[_opaque_pthread_rwlock_t] = Tag.materializeCStruct2Tag[CLongInt, CArray[CChar, Nat.Digit3[Nat._1, Nat._9, Nat._2]]]
    def apply()(using Zone): Ptr[_opaque_pthread_rwlock_t] = scala.scalanative.unsafe.alloc[_opaque_pthread_rwlock_t](1)
    def apply(__sig: CLongInt, __opaque: CArray[CChar, Nat.Digit3[Nat._1, Nat._9, Nat._2]])(using Zone): Ptr[_opaque_pthread_rwlock_t] = 
      val ____ptr = apply()
      (!____ptr).__sig = __sig
      (!____ptr).__opaque = __opaque
      ____ptr
    extension (struct: _opaque_pthread_rwlock_t)
      def __sig: CLongInt = struct._1
      def __sig_=(value: CLongInt): Unit = !struct.at1 = value
      def __opaque: CArray[CChar, Nat.Digit3[Nat._1, Nat._9, Nat._2]] = struct._2
      def __opaque_=(value: CArray[CChar, Nat.Digit3[Nat._1, Nat._9, Nat._2]]): Unit = !struct.at2 = value

  opaque type _opaque_pthread_rwlockattr_t = CStruct2[CLongInt, CArray[CChar, Nat.Digit2[Nat._1, Nat._6]]]
  object _opaque_pthread_rwlockattr_t:
    given _tag: Tag[_opaque_pthread_rwlockattr_t] = Tag.materializeCStruct2Tag[CLongInt, CArray[CChar, Nat.Digit2[Nat._1, Nat._6]]]
    def apply()(using Zone): Ptr[_opaque_pthread_rwlockattr_t] = scala.scalanative.unsafe.alloc[_opaque_pthread_rwlockattr_t](1)
    def apply(__sig: CLongInt, __opaque: CArray[CChar, Nat.Digit2[Nat._1, Nat._6]])(using Zone): Ptr[_opaque_pthread_rwlockattr_t] = 
      val ____ptr = apply()
      (!____ptr).__sig = __sig
      (!____ptr).__opaque = __opaque
      ____ptr
    extension (struct: _opaque_pthread_rwlockattr_t)
      def __sig: CLongInt = struct._1
      def __sig_=(value: CLongInt): Unit = !struct.at1 = value
      def __opaque: CArray[CChar, Nat.Digit2[Nat._1, Nat._6]] = struct._2
      def __opaque_=(value: CArray[CChar, Nat.Digit2[Nat._1, Nat._6]]): Unit = !struct.at2 = value

  opaque type _opaque_pthread_t = CStruct3[CLongInt, Ptr[Byte], CArray[CChar, Nat.Digit4[Nat._8, Nat._1, Nat._7, Nat._6]]]
  object _opaque_pthread_t:
    given _tag: Tag[_opaque_pthread_t] = Tag.materializeCStruct3Tag[CLongInt, Ptr[Byte], CArray[CChar, Nat.Digit4[Nat._8, Nat._1, Nat._7, Nat._6]]]
    def apply()(using Zone): Ptr[_opaque_pthread_t] = scala.scalanative.unsafe.alloc[_opaque_pthread_t](1)
    def apply(__sig: CLongInt, __cleanup_stack: Ptr[__darwin_pthread_handler_rec], __opaque: CArray[CChar, Nat.Digit4[Nat._8, Nat._1, Nat._7, Nat._6]])(using Zone): Ptr[_opaque_pthread_t] = 
      val ____ptr = apply()
      (!____ptr).__sig = __sig
      (!____ptr).__cleanup_stack = __cleanup_stack
      (!____ptr).__opaque = __opaque
      ____ptr
    extension (struct: _opaque_pthread_t)
      def __sig: CLongInt = struct._1
      def __sig_=(value: CLongInt): Unit = !struct.at1 = value
      def __cleanup_stack: Ptr[__darwin_pthread_handler_rec] = struct._2.asInstanceOf[Ptr[__darwin_pthread_handler_rec]]
      def __cleanup_stack_=(value: Ptr[__darwin_pthread_handler_rec]): Unit = !struct.at2 = value.asInstanceOf[Ptr[Byte]]
      def __opaque: CArray[CChar, Nat.Digit4[Nat._8, Nat._1, Nat._7, Nat._6]] = struct._3
      def __opaque_=(value: CArray[CChar, Nat.Digit4[Nat._8, Nat._1, Nat._7, Nat._6]]): Unit = !struct.at3 = value

  opaque type clockinfo = CStruct5[CInt, CInt, CInt, CInt, CInt]
  object clockinfo:
    given _tag: Tag[clockinfo] = Tag.materializeCStruct5Tag[CInt, CInt, CInt, CInt, CInt]
    def apply()(using Zone): Ptr[clockinfo] = scala.scalanative.unsafe.alloc[clockinfo](1)
    def apply(hz: CInt, tick: CInt, tickadj: CInt, stathz: CInt, profhz: CInt)(using Zone): Ptr[clockinfo] = 
      val ____ptr = apply()
      (!____ptr).hz = hz
      (!____ptr).tick = tick
      (!____ptr).tickadj = tickadj
      (!____ptr).stathz = stathz
      (!____ptr).profhz = profhz
      ____ptr
    extension (struct: clockinfo)
      def hz: CInt = struct._1
      def hz_=(value: CInt): Unit = !struct.at1 = value
      def tick: CInt = struct._2
      def tick_=(value: CInt): Unit = !struct.at2 = value
      def tickadj: CInt = struct._3
      def tickadj_=(value: CInt): Unit = !struct.at3 = value
      def stathz: CInt = struct._4
      def stathz_=(value: CInt): Unit = !struct.at4 = value
      def profhz: CInt = struct._5
      def profhz_=(value: CInt): Unit = !struct.at5 = value

  opaque type cmsghdr = CStruct3[socklen_t, CInt, CInt]
  object cmsghdr:
    given _tag: Tag[cmsghdr] = Tag.materializeCStruct3Tag[socklen_t, CInt, CInt]
    def apply()(using Zone): Ptr[cmsghdr] = scala.scalanative.unsafe.alloc[cmsghdr](1)
    def apply(cmsg_len: socklen_t, cmsg_level: CInt, cmsg_type: CInt)(using Zone): Ptr[cmsghdr] = 
      val ____ptr = apply()
      (!____ptr).cmsg_len = cmsg_len
      (!____ptr).cmsg_level = cmsg_level
      (!____ptr).cmsg_type = cmsg_type
      ____ptr
    extension (struct: cmsghdr)
      def cmsg_len: socklen_t = struct._1
      def cmsg_len_=(value: socklen_t): Unit = !struct.at1 = value
      def cmsg_level: CInt = struct._2
      def cmsg_level_=(value: CInt): Unit = !struct.at2 = value
      def cmsg_type: CInt = struct._3
      def cmsg_type_=(value: CInt): Unit = !struct.at3 = value

  opaque type curl_blob = CStruct3[Ptr[Byte], size_t, CUnsignedInt]
  object curl_blob:
    given _tag: Tag[curl_blob] = Tag.materializeCStruct3Tag[Ptr[Byte], size_t, CUnsignedInt]
    def apply()(using Zone): Ptr[curl_blob] = scala.scalanative.unsafe.alloc[curl_blob](1)
    def apply(data: Ptr[Byte], len: size_t, flags: CUnsignedInt)(using Zone): Ptr[curl_blob] = 
      val ____ptr = apply()
      (!____ptr).data = data
      (!____ptr).len = len
      (!____ptr).flags = flags
      ____ptr
    extension (struct: curl_blob)
      def data: Ptr[Byte] = struct._1
      def data_=(value: Ptr[Byte]): Unit = !struct.at1 = value
      def len: size_t = struct._2
      def len_=(value: size_t): Unit = !struct.at2 = value
      def flags: CUnsignedInt = struct._3
      def flags_=(value: CUnsignedInt): Unit = !struct.at3 = value

  opaque type curl_certinfo = CStruct2[CInt, Ptr[Ptr[curl_slist]]]
  object curl_certinfo:
    given _tag: Tag[curl_certinfo] = Tag.materializeCStruct2Tag[CInt, Ptr[Ptr[curl_slist]]]
    def apply()(using Zone): Ptr[curl_certinfo] = scala.scalanative.unsafe.alloc[curl_certinfo](1)
    def apply(num_of_certs: CInt, certinfo: Ptr[Ptr[curl_slist]])(using Zone): Ptr[curl_certinfo] = 
      val ____ptr = apply()
      (!____ptr).num_of_certs = num_of_certs
      (!____ptr).certinfo = certinfo
      ____ptr
    extension (struct: curl_certinfo)
      def num_of_certs: CInt = struct._1
      def num_of_certs_=(value: CInt): Unit = !struct.at1 = value
      def certinfo: Ptr[Ptr[curl_slist]] = struct._2
      def certinfo_=(value: Ptr[Ptr[curl_slist]]): Unit = !struct.at2 = value

  opaque type curl_easyoption = CStruct4[CString, CURLoption, curl_easytype, CUnsignedInt]
  object curl_easyoption:
    given _tag: Tag[curl_easyoption] = Tag.materializeCStruct4Tag[CString, CURLoption, curl_easytype, CUnsignedInt]
    def apply()(using Zone): Ptr[curl_easyoption] = scala.scalanative.unsafe.alloc[curl_easyoption](1)
    def apply(name: CString, id: CURLoption, `type`: curl_easytype, flags: CUnsignedInt)(using Zone): Ptr[curl_easyoption] = 
      val ____ptr = apply()
      (!____ptr).name = name
      (!____ptr).id = id
      (!____ptr).`type` = `type`
      (!____ptr).flags = flags
      ____ptr
    extension (struct: curl_easyoption)
      def name: CString = struct._1
      def name_=(value: CString): Unit = !struct.at1 = value
      def id: CURLoption = struct._2
      def id_=(value: CURLoption): Unit = !struct.at2 = value
      def `type`: curl_easytype = struct._3
      def type_=(value: curl_easytype): Unit = !struct.at3 = value
      def flags: CUnsignedInt = struct._4
      def flags_=(value: CUnsignedInt): Unit = !struct.at4 = value

  opaque type curl_fileinfo = CStruct13[CString, curlfiletype, time_t, CUnsignedInt, CInt, CInt, curl_off_t, CLongInt, curl_fileinfo.Struct0, CUnsignedInt, CString, size_t, size_t]
  object curl_fileinfo:
    opaque type Struct0 = CStruct5[CString, CString, CString, CString, CString]
    object Struct0:
      given _tag: Tag[Struct0] = Tag.materializeCStruct5Tag[CString, CString, CString, CString, CString]
      def apply()(using Zone): Ptr[Struct0] = scala.scalanative.unsafe.alloc[Struct0](1)
      def apply(time: CString, perm: CString, user: CString, group: CString, target: CString)(using Zone): Ptr[Struct0] = 
        val ____ptr = apply()
        (!____ptr).time = time
        (!____ptr).perm = perm
        (!____ptr).user = user
        (!____ptr).group = group
        (!____ptr).target = target
        ____ptr
      extension (struct: Struct0)
        def time: CString = struct._1
        def time_=(value: CString): Unit = !struct.at1 = value
        def perm: CString = struct._2
        def perm_=(value: CString): Unit = !struct.at2 = value
        def user: CString = struct._3
        def user_=(value: CString): Unit = !struct.at3 = value
        def group: CString = struct._4
        def group_=(value: CString): Unit = !struct.at4 = value
        def target: CString = struct._5
        def target_=(value: CString): Unit = !struct.at5 = value
    given _tag: Tag[curl_fileinfo] = Tag.materializeCStruct13Tag[CString, curlfiletype, time_t, CUnsignedInt, CInt, CInt, curl_off_t, CLongInt, curl_fileinfo.Struct0, CUnsignedInt, CString, size_t, size_t]
    def apply()(using Zone): Ptr[curl_fileinfo] = scala.scalanative.unsafe.alloc[curl_fileinfo](1)
    def apply(filename: CString, filetype: curlfiletype, time: time_t, perm: CUnsignedInt, uid: CInt, gid: CInt, size: curl_off_t, hardlinks: CLongInt, strings: curl_fileinfo.Struct0, flags: CUnsignedInt, b_data: CString, b_size: size_t, b_used: size_t)(using Zone): Ptr[curl_fileinfo] = 
      val ____ptr = apply()
      (!____ptr).filename = filename
      (!____ptr).filetype = filetype
      (!____ptr).time = time
      (!____ptr).perm = perm
      (!____ptr).uid = uid
      (!____ptr).gid = gid
      (!____ptr).size = size
      (!____ptr).hardlinks = hardlinks
      (!____ptr).strings = strings
      (!____ptr).flags = flags
      (!____ptr).b_data = b_data
      (!____ptr).b_size = b_size
      (!____ptr).b_used = b_used
      ____ptr
    extension (struct: curl_fileinfo)
      def filename: CString = struct._1
      def filename_=(value: CString): Unit = !struct.at1 = value
      def filetype: curlfiletype = struct._2
      def filetype_=(value: curlfiletype): Unit = !struct.at2 = value
      def time: time_t = struct._3
      def time_=(value: time_t): Unit = !struct.at3 = value
      def perm: CUnsignedInt = struct._4
      def perm_=(value: CUnsignedInt): Unit = !struct.at4 = value
      def uid: CInt = struct._5
      def uid_=(value: CInt): Unit = !struct.at5 = value
      def gid: CInt = struct._6
      def gid_=(value: CInt): Unit = !struct.at6 = value
      def size: curl_off_t = struct._7
      def size_=(value: curl_off_t): Unit = !struct.at7 = value
      def hardlinks: CLongInt = struct._8
      def hardlinks_=(value: CLongInt): Unit = !struct.at8 = value
      def strings: curl_fileinfo.Struct0 = struct._9
      def strings_=(value: curl_fileinfo.Struct0): Unit = !struct.at9 = value
      def flags: CUnsignedInt = struct._10
      def flags_=(value: CUnsignedInt): Unit = !struct.at10 = value
      def b_data: CString = struct._11
      def b_data_=(value: CString): Unit = !struct.at11 = value
      def b_size: size_t = struct._12
      def b_size_=(value: size_t): Unit = !struct.at12 = value
      def b_used: size_t = struct._13
      def b_used_=(value: size_t): Unit = !struct.at13 = value

  opaque type curl_forms = CStruct2[CURLformoption, CString]
  object curl_forms:
    given _tag: Tag[curl_forms] = Tag.materializeCStruct2Tag[CURLformoption, CString]
    def apply()(using Zone): Ptr[curl_forms] = scala.scalanative.unsafe.alloc[curl_forms](1)
    def apply(option: CURLformoption, value: CString)(using Zone): Ptr[curl_forms] = 
      val ____ptr = apply()
      (!____ptr).option = option
      (!____ptr).value = value
      ____ptr
    extension (struct: curl_forms)
      def option: CURLformoption = struct._1
      def option_=(value: CURLformoption): Unit = !struct.at1 = value
      def value: CString = struct._2
      def value_=(value: CString): Unit = !struct.at2 = value

  opaque type curl_hstsentry = CStruct4[CString, size_t, CUnsignedInt, CArray[CChar, Nat.Digit2[Nat._1, Nat._8]]]
  object curl_hstsentry:
    given _tag: Tag[curl_hstsentry] = Tag.materializeCStruct4Tag[CString, size_t, CUnsignedInt, CArray[CChar, Nat.Digit2[Nat._1, Nat._8]]]
    def apply()(using Zone): Ptr[curl_hstsentry] = scala.scalanative.unsafe.alloc[curl_hstsentry](1)
    def apply(name: CString, namelen: size_t, includeSubDomains: CUnsignedInt, expire: CArray[CChar, Nat.Digit2[Nat._1, Nat._8]])(using Zone): Ptr[curl_hstsentry] = 
      val ____ptr = apply()
      (!____ptr).name = name
      (!____ptr).namelen = namelen
      (!____ptr).includeSubDomains = includeSubDomains
      (!____ptr).expire = expire
      ____ptr
    extension (struct: curl_hstsentry)
      def name: CString = struct._1
      def name_=(value: CString): Unit = !struct.at1 = value
      def namelen: size_t = struct._2
      def namelen_=(value: size_t): Unit = !struct.at2 = value
      def includeSubDomains: CUnsignedInt = struct._3
      def includeSubDomains_=(value: CUnsignedInt): Unit = !struct.at3 = value
      def expire: CArray[CChar, Nat.Digit2[Nat._1, Nat._8]] = struct._4
      def expire_=(value: CArray[CChar, Nat.Digit2[Nat._1, Nat._8]]): Unit = !struct.at4 = value

  opaque type curl_httppost = CStruct14[Ptr[Byte], CString, CLongInt, CString, CLongInt, CString, CLongInt, CString, Ptr[Byte], Ptr[Byte], CLongInt, CString, Ptr[Byte], curl_off_t]
  object curl_httppost:
    opaque type Struct0 = CStruct0
    object Struct0:
      given _tag: Tag[Struct0] = Tag.materializeCStruct0Tag
    given _tag: Tag[curl_httppost] = Tag.materializeCStruct14Tag[Ptr[Byte], CString, CLongInt, CString, CLongInt, CString, CLongInt, CString, Ptr[Byte], Ptr[Byte], CLongInt, CString, Ptr[Byte], curl_off_t]
    def apply()(using Zone): Ptr[curl_httppost] = scala.scalanative.unsafe.alloc[curl_httppost](1)
    def apply(next: Ptr[curl_httppost], name: CString, namelength: CLongInt, contents: CString, contentslength: CLongInt, buffer: CString, bufferlength: CLongInt, contenttype: CString, contentheader: Ptr[curl_slist], more: Ptr[curl_httppost], flags: CLongInt, showfilename: CString, userp: Ptr[Byte], contentlen: curl_off_t)(using Zone): Ptr[curl_httppost] = 
      val ____ptr = apply()
      (!____ptr).next = next
      (!____ptr).name = name
      (!____ptr).namelength = namelength
      (!____ptr).contents = contents
      (!____ptr).contentslength = contentslength
      (!____ptr).buffer = buffer
      (!____ptr).bufferlength = bufferlength
      (!____ptr).contenttype = contenttype
      (!____ptr).contentheader = contentheader
      (!____ptr).more = more
      (!____ptr).flags = flags
      (!____ptr).showfilename = showfilename
      (!____ptr).userp = userp
      (!____ptr).contentlen = contentlen
      ____ptr
    extension (struct: curl_httppost)
      def next: Ptr[curl_httppost] = struct._1.asInstanceOf[Ptr[curl_httppost]]
      def next_=(value: Ptr[curl_httppost]): Unit = !struct.at1 = value.asInstanceOf[Ptr[Byte]]
      def name: CString = struct._2
      def name_=(value: CString): Unit = !struct.at2 = value
      def namelength: CLongInt = struct._3
      def namelength_=(value: CLongInt): Unit = !struct.at3 = value
      def contents: CString = struct._4
      def contents_=(value: CString): Unit = !struct.at4 = value
      def contentslength: CLongInt = struct._5
      def contentslength_=(value: CLongInt): Unit = !struct.at5 = value
      def buffer: CString = struct._6
      def buffer_=(value: CString): Unit = !struct.at6 = value
      def bufferlength: CLongInt = struct._7
      def bufferlength_=(value: CLongInt): Unit = !struct.at7 = value
      def contenttype: CString = struct._8
      def contenttype_=(value: CString): Unit = !struct.at8 = value
      def contentheader: Ptr[curl_slist] = struct._9.asInstanceOf[Ptr[curl_slist]]
      def contentheader_=(value: Ptr[curl_slist]): Unit = !struct.at9 = value.asInstanceOf[Ptr[Byte]]
      def more: Ptr[curl_httppost] = struct._10.asInstanceOf[Ptr[curl_httppost]]
      def more_=(value: Ptr[curl_httppost]): Unit = !struct.at10 = value.asInstanceOf[Ptr[Byte]]
      def flags: CLongInt = struct._11
      def flags_=(value: CLongInt): Unit = !struct.at11 = value
      def showfilename: CString = struct._12
      def showfilename_=(value: CString): Unit = !struct.at12 = value
      def userp: Ptr[Byte] = struct._13
      def userp_=(value: Ptr[Byte]): Unit = !struct.at13 = value
      def contentlen: curl_off_t = struct._14
      def contentlen_=(value: curl_off_t): Unit = !struct.at14 = value

  opaque type curl_index = CStruct2[size_t, size_t]
  object curl_index:
    given _tag: Tag[curl_index] = Tag.materializeCStruct2Tag[size_t, size_t]
    def apply()(using Zone): Ptr[curl_index] = scala.scalanative.unsafe.alloc[curl_index](1)
    def apply(index: size_t, total: size_t)(using Zone): Ptr[curl_index] = 
      val ____ptr = apply()
      (!____ptr).index = index
      (!____ptr).total = total
      ____ptr
    extension (struct: curl_index)
      def index: size_t = struct._1
      def index_=(value: size_t): Unit = !struct.at1 = value
      def total: size_t = struct._2
      def total_=(value: size_t): Unit = !struct.at2 = value

  opaque type curl_khkey = CStruct3[CString, size_t, curl_khtype]
  object curl_khkey:
    given _tag: Tag[curl_khkey] = Tag.materializeCStruct3Tag[CString, size_t, curl_khtype]
    def apply()(using Zone): Ptr[curl_khkey] = scala.scalanative.unsafe.alloc[curl_khkey](1)
    def apply(key: CString, len: size_t, keytype: curl_khtype)(using Zone): Ptr[curl_khkey] = 
      val ____ptr = apply()
      (!____ptr).key = key
      (!____ptr).len = len
      (!____ptr).keytype = keytype
      ____ptr
    extension (struct: curl_khkey)
      def key: CString = struct._1
      def key_=(value: CString): Unit = !struct.at1 = value
      def len: size_t = struct._2
      def len_=(value: size_t): Unit = !struct.at2 = value
      def keytype: curl_khtype = struct._3
      def keytype_=(value: curl_khtype): Unit = !struct.at3 = value

  opaque type curl_mime = CStruct0
  object curl_mime:
    given _tag: Tag[curl_mime] = Tag.materializeCStruct0Tag

  opaque type curl_mimepart = CStruct0
  object curl_mimepart:
    given _tag: Tag[curl_mimepart] = Tag.materializeCStruct0Tag

  opaque type curl_pushheaders = CStruct0
  object curl_pushheaders:
    given _tag: Tag[curl_pushheaders] = Tag.materializeCStruct0Tag

  opaque type curl_slist = CStruct2[CString, Ptr[Byte]]
  object curl_slist:
    given _tag: Tag[curl_slist] = Tag.materializeCStruct2Tag[CString, Ptr[Byte]]
    def apply()(using Zone): Ptr[curl_slist] = scala.scalanative.unsafe.alloc[curl_slist](1)
    def apply(data: CString, next: Ptr[curl_slist])(using Zone): Ptr[curl_slist] = 
      val ____ptr = apply()
      (!____ptr).data = data
      (!____ptr).next = next
      ____ptr
    extension (struct: curl_slist)
      def data: CString = struct._1
      def data_=(value: CString): Unit = !struct.at1 = value
      def next: Ptr[curl_slist] = struct._2.asInstanceOf[Ptr[curl_slist]]
      def next_=(value: Ptr[curl_slist]): Unit = !struct.at2 = value.asInstanceOf[Ptr[Byte]]

  opaque type curl_sockaddr = CStruct5[CInt, CInt, CInt, CUnsignedInt, sockaddr]
  object curl_sockaddr:
    given _tag: Tag[curl_sockaddr] = Tag.materializeCStruct5Tag[CInt, CInt, CInt, CUnsignedInt, sockaddr]
    def apply()(using Zone): Ptr[curl_sockaddr] = scala.scalanative.unsafe.alloc[curl_sockaddr](1)
    def apply(family: CInt, socktype: CInt, protocol: CInt, addrlen: CUnsignedInt, addr: sockaddr)(using Zone): Ptr[curl_sockaddr] = 
      val ____ptr = apply()
      (!____ptr).family = family
      (!____ptr).socktype = socktype
      (!____ptr).protocol = protocol
      (!____ptr).addrlen = addrlen
      (!____ptr).addr = addr
      ____ptr
    extension (struct: curl_sockaddr)
      def family: CInt = struct._1
      def family_=(value: CInt): Unit = !struct.at1 = value
      def socktype: CInt = struct._2
      def socktype_=(value: CInt): Unit = !struct.at2 = value
      def protocol: CInt = struct._3
      def protocol_=(value: CInt): Unit = !struct.at3 = value
      def addrlen: CUnsignedInt = struct._4
      def addrlen_=(value: CUnsignedInt): Unit = !struct.at4 = value
      def addr: sockaddr = struct._5
      def addr_=(value: sockaddr): Unit = !struct.at5 = value

  opaque type curl_ssl_backend = CStruct2[curl_sslbackend, CString]
  object curl_ssl_backend:
    given _tag: Tag[curl_ssl_backend] = Tag.materializeCStruct2Tag[curl_sslbackend, CString]
    def apply()(using Zone): Ptr[curl_ssl_backend] = scala.scalanative.unsafe.alloc[curl_ssl_backend](1)
    def apply(id: curl_sslbackend, name: CString)(using Zone): Ptr[curl_ssl_backend] = 
      val ____ptr = apply()
      (!____ptr).id = id
      (!____ptr).name = name
      ____ptr
    extension (struct: curl_ssl_backend)
      def id: curl_sslbackend = struct._1
      def id_=(value: curl_sslbackend): Unit = !struct.at1 = value
      def name: CString = struct._2
      def name_=(value: CString): Unit = !struct.at2 = value

  opaque type curl_tlssessioninfo = CStruct2[curl_sslbackend, Ptr[Byte]]
  object curl_tlssessioninfo:
    given _tag: Tag[curl_tlssessioninfo] = Tag.materializeCStruct2Tag[curl_sslbackend, Ptr[Byte]]
    def apply()(using Zone): Ptr[curl_tlssessioninfo] = scala.scalanative.unsafe.alloc[curl_tlssessioninfo](1)
    def apply(backend: curl_sslbackend, internals: Ptr[Byte])(using Zone): Ptr[curl_tlssessioninfo] = 
      val ____ptr = apply()
      (!____ptr).backend = backend
      (!____ptr).internals = internals
      ____ptr
    extension (struct: curl_tlssessioninfo)
      def backend: curl_sslbackend = struct._1
      def backend_=(value: curl_sslbackend): Unit = !struct.at1 = value
      def internals: Ptr[Byte] = struct._2
      def internals_=(value: Ptr[Byte]): Unit = !struct.at2 = value

  opaque type curl_version_info_data = CArray[Byte, Nat.Digit3[Nat._2, Nat._0, Nat._0]]
  object curl_version_info_data:
    given _tag: Tag[curl_version_info_data] = Tag.CArray[CChar, Nat.Digit3[Nat._2, Nat._0, Nat._0]](Tag.Byte, Tag.Digit3[Nat._2, Nat._0, Nat._0](Tag.Nat2, Tag.Nat0, Tag.Nat0))
    def apply()(using Zone): Ptr[curl_version_info_data] = scala.scalanative.unsafe.alloc[curl_version_info_data](1)
    def apply(age: CURLversion, version: CString, version_num: CUnsignedInt, host: CString, features: CInt, ssl_version: CString, ssl_version_num: CLongInt, libz_version: CString, protocols: Ptr[CString], ares: CString, ares_num: CInt, libidn: CString, iconv_ver_num: CInt, libssh_version: CString, brotli_ver_num: CUnsignedInt, brotli_version: CString, nghttp2_ver_num: CUnsignedInt, nghttp2_version: CString, quic_version: CString, cainfo: CString, capath: CString, zstd_ver_num: CUnsignedInt, zstd_version: CString, hyper_version: CString, gsasl_version: CString)(using Zone): Ptr[curl_version_info_data] = 
      val ____ptr = apply()
      (!____ptr).age = age
      (!____ptr).version = version
      (!____ptr).version_num = version_num
      (!____ptr).host = host
      (!____ptr).features = features
      (!____ptr).ssl_version = ssl_version
      (!____ptr).ssl_version_num = ssl_version_num
      (!____ptr).libz_version = libz_version
      (!____ptr).protocols = protocols
      (!____ptr).ares = ares
      (!____ptr).ares_num = ares_num
      (!____ptr).libidn = libidn
      (!____ptr).iconv_ver_num = iconv_ver_num
      (!____ptr).libssh_version = libssh_version
      (!____ptr).brotli_ver_num = brotli_ver_num
      (!____ptr).brotli_version = brotli_version
      (!____ptr).nghttp2_ver_num = nghttp2_ver_num
      (!____ptr).nghttp2_version = nghttp2_version
      (!____ptr).quic_version = quic_version
      (!____ptr).cainfo = cainfo
      (!____ptr).capath = capath
      (!____ptr).zstd_ver_num = zstd_ver_num
      (!____ptr).zstd_version = zstd_version
      (!____ptr).hyper_version = hyper_version
      (!____ptr).gsasl_version = gsasl_version
      ____ptr
    extension (struct: curl_version_info_data)
      def age: CURLversion = !struct.at(0).asInstanceOf[Ptr[CURLversion]]
      def age_=(value: CURLversion): Unit = !struct.at(0).asInstanceOf[Ptr[CURLversion]] = value
      def version: CString = !struct.at(8).asInstanceOf[Ptr[CString]]
      def version_=(value: CString): Unit = !struct.at(8).asInstanceOf[Ptr[CString]] = value
      def version_num: CUnsignedInt = !struct.at(16).asInstanceOf[Ptr[CUnsignedInt]]
      def version_num_=(value: CUnsignedInt): Unit = !struct.at(16).asInstanceOf[Ptr[CUnsignedInt]] = value
      def host: CString = !struct.at(24).asInstanceOf[Ptr[CString]]
      def host_=(value: CString): Unit = !struct.at(24).asInstanceOf[Ptr[CString]] = value
      def features: CInt = !struct.at(32).asInstanceOf[Ptr[CInt]]
      def features_=(value: CInt): Unit = !struct.at(32).asInstanceOf[Ptr[CInt]] = value
      def ssl_version: CString = !struct.at(40).asInstanceOf[Ptr[CString]]
      def ssl_version_=(value: CString): Unit = !struct.at(40).asInstanceOf[Ptr[CString]] = value
      def ssl_version_num: CLongInt = !struct.at(48).asInstanceOf[Ptr[CLongInt]]
      def ssl_version_num_=(value: CLongInt): Unit = !struct.at(48).asInstanceOf[Ptr[CLongInt]] = value
      def libz_version: CString = !struct.at(56).asInstanceOf[Ptr[CString]]
      def libz_version_=(value: CString): Unit = !struct.at(56).asInstanceOf[Ptr[CString]] = value
      def protocols: Ptr[CString] = !struct.at(64).asInstanceOf[Ptr[Ptr[CString]]]
      def protocols_=(value: Ptr[CString]): Unit = !struct.at(64).asInstanceOf[Ptr[Ptr[CString]]] = value
      def ares: CString = !struct.at(72).asInstanceOf[Ptr[CString]]
      def ares_=(value: CString): Unit = !struct.at(72).asInstanceOf[Ptr[CString]] = value
      def ares_num: CInt = !struct.at(80).asInstanceOf[Ptr[CInt]]
      def ares_num_=(value: CInt): Unit = !struct.at(80).asInstanceOf[Ptr[CInt]] = value
      def libidn: CString = !struct.at(88).asInstanceOf[Ptr[CString]]
      def libidn_=(value: CString): Unit = !struct.at(88).asInstanceOf[Ptr[CString]] = value
      def iconv_ver_num: CInt = !struct.at(96).asInstanceOf[Ptr[CInt]]
      def iconv_ver_num_=(value: CInt): Unit = !struct.at(96).asInstanceOf[Ptr[CInt]] = value
      def libssh_version: CString = !struct.at(104).asInstanceOf[Ptr[CString]]
      def libssh_version_=(value: CString): Unit = !struct.at(104).asInstanceOf[Ptr[CString]] = value
      def brotli_ver_num: CUnsignedInt = !struct.at(112).asInstanceOf[Ptr[CUnsignedInt]]
      def brotli_ver_num_=(value: CUnsignedInt): Unit = !struct.at(112).asInstanceOf[Ptr[CUnsignedInt]] = value
      def brotli_version: CString = !struct.at(120).asInstanceOf[Ptr[CString]]
      def brotli_version_=(value: CString): Unit = !struct.at(120).asInstanceOf[Ptr[CString]] = value
      def nghttp2_ver_num: CUnsignedInt = !struct.at(128).asInstanceOf[Ptr[CUnsignedInt]]
      def nghttp2_ver_num_=(value: CUnsignedInt): Unit = !struct.at(128).asInstanceOf[Ptr[CUnsignedInt]] = value
      def nghttp2_version: CString = !struct.at(136).asInstanceOf[Ptr[CString]]
      def nghttp2_version_=(value: CString): Unit = !struct.at(136).asInstanceOf[Ptr[CString]] = value
      def quic_version: CString = !struct.at(144).asInstanceOf[Ptr[CString]]
      def quic_version_=(value: CString): Unit = !struct.at(144).asInstanceOf[Ptr[CString]] = value
      def cainfo: CString = !struct.at(152).asInstanceOf[Ptr[CString]]
      def cainfo_=(value: CString): Unit = !struct.at(152).asInstanceOf[Ptr[CString]] = value
      def capath: CString = !struct.at(160).asInstanceOf[Ptr[CString]]
      def capath_=(value: CString): Unit = !struct.at(160).asInstanceOf[Ptr[CString]] = value
      def zstd_ver_num: CUnsignedInt = !struct.at(168).asInstanceOf[Ptr[CUnsignedInt]]
      def zstd_ver_num_=(value: CUnsignedInt): Unit = !struct.at(168).asInstanceOf[Ptr[CUnsignedInt]] = value
      def zstd_version: CString = !struct.at(176).asInstanceOf[Ptr[CString]]
      def zstd_version_=(value: CString): Unit = !struct.at(176).asInstanceOf[Ptr[CString]] = value
      def hyper_version: CString = !struct.at(184).asInstanceOf[Ptr[CString]]
      def hyper_version_=(value: CString): Unit = !struct.at(184).asInstanceOf[Ptr[CString]] = value
      def gsasl_version: CString = !struct.at(192).asInstanceOf[Ptr[CString]]
      def gsasl_version_=(value: CString): Unit = !struct.at(192).asInstanceOf[Ptr[CString]] = value

  opaque type curl_waitfd = CStruct3[curl_socket_t, CShort, CShort]
  object curl_waitfd:
    given _tag: Tag[curl_waitfd] = Tag.materializeCStruct3Tag[curl_socket_t, CShort, CShort]
    def apply()(using Zone): Ptr[curl_waitfd] = scala.scalanative.unsafe.alloc[curl_waitfd](1)
    def apply(fd: curl_socket_t, events: CShort, revents: CShort)(using Zone): Ptr[curl_waitfd] = 
      val ____ptr = apply()
      (!____ptr).fd = fd
      (!____ptr).events = events
      (!____ptr).revents = revents
      ____ptr
    extension (struct: curl_waitfd)
      def fd: curl_socket_t = struct._1
      def fd_=(value: curl_socket_t): Unit = !struct.at1 = value
      def events: CShort = struct._2
      def events_=(value: CShort): Unit = !struct.at2 = value
      def revents: CShort = struct._3
      def revents_=(value: CShort): Unit = !struct.at3 = value

  opaque type fd_set = CStruct1[CArray[__int32_t, Nat.Digit2[Nat._3, Nat._2]]]
  object fd_set:
    given _tag: Tag[fd_set] = Tag.materializeCStruct1Tag[CArray[__int32_t, Nat.Digit2[Nat._3, Nat._2]]]
    def apply()(using Zone): Ptr[fd_set] = scala.scalanative.unsafe.alloc[fd_set](1)
    def apply(fds_bits: CArray[__int32_t, Nat.Digit2[Nat._3, Nat._2]])(using Zone): Ptr[fd_set] = 
      val ____ptr = apply()
      (!____ptr).fds_bits = fds_bits
      ____ptr
    extension (struct: fd_set)
      def fds_bits: CArray[__int32_t, Nat.Digit2[Nat._3, Nat._2]] = struct._1
      def fds_bits_=(value: CArray[__int32_t, Nat.Digit2[Nat._3, Nat._2]]): Unit = !struct.at1 = value

  opaque type iovec = CStruct2[Ptr[Byte], size_t]
  object iovec:
    given _tag: Tag[iovec] = Tag.materializeCStruct2Tag[Ptr[Byte], size_t]
    def apply()(using Zone): Ptr[iovec] = scala.scalanative.unsafe.alloc[iovec](1)
    def apply(iov_base: Ptr[Byte], iov_len: size_t)(using Zone): Ptr[iovec] = 
      val ____ptr = apply()
      (!____ptr).iov_base = iov_base
      (!____ptr).iov_len = iov_len
      ____ptr
    extension (struct: iovec)
      def iov_base: Ptr[Byte] = struct._1
      def iov_base_=(value: Ptr[Byte]): Unit = !struct.at1 = value
      def iov_len: size_t = struct._2
      def iov_len_=(value: size_t): Unit = !struct.at2 = value

  opaque type itimerval = CStruct2[timeval, timeval]
  object itimerval:
    given _tag: Tag[itimerval] = Tag.materializeCStruct2Tag[timeval, timeval]
    def apply()(using Zone): Ptr[itimerval] = scala.scalanative.unsafe.alloc[itimerval](1)
    def apply(it_interval: timeval, it_value: timeval)(using Zone): Ptr[itimerval] = 
      val ____ptr = apply()
      (!____ptr).it_interval = it_interval
      (!____ptr).it_value = it_value
      ____ptr
    extension (struct: itimerval)
      def it_interval: timeval = struct._1
      def it_interval_=(value: timeval): Unit = !struct.at1 = value
      def it_value: timeval = struct._2
      def it_value_=(value: timeval): Unit = !struct.at2 = value

  opaque type linger = CStruct2[CInt, CInt]
  object linger:
    given _tag: Tag[linger] = Tag.materializeCStruct2Tag[CInt, CInt]
    def apply()(using Zone): Ptr[linger] = scala.scalanative.unsafe.alloc[linger](1)
    def apply(l_onoff: CInt, l_linger: CInt)(using Zone): Ptr[linger] = 
      val ____ptr = apply()
      (!____ptr).l_onoff = l_onoff
      (!____ptr).l_linger = l_linger
      ____ptr
    extension (struct: linger)
      def l_onoff: CInt = struct._1
      def l_onoff_=(value: CInt): Unit = !struct.at1 = value
      def l_linger: CInt = struct._2
      def l_linger_=(value: CInt): Unit = !struct.at2 = value

  opaque type msghdr = CStruct7[Ptr[Byte], socklen_t, Ptr[iovec], CInt, Ptr[Byte], socklen_t, CInt]
  object msghdr:
    given _tag: Tag[msghdr] = Tag.materializeCStruct7Tag[Ptr[Byte], socklen_t, Ptr[iovec], CInt, Ptr[Byte], socklen_t, CInt]
    def apply()(using Zone): Ptr[msghdr] = scala.scalanative.unsafe.alloc[msghdr](1)
    def apply(msg_name: Ptr[Byte], msg_namelen: socklen_t, msg_iov: Ptr[iovec], msg_iovlen: CInt, msg_control: Ptr[Byte], msg_controllen: socklen_t, msg_flags: CInt)(using Zone): Ptr[msghdr] = 
      val ____ptr = apply()
      (!____ptr).msg_name = msg_name
      (!____ptr).msg_namelen = msg_namelen
      (!____ptr).msg_iov = msg_iov
      (!____ptr).msg_iovlen = msg_iovlen
      (!____ptr).msg_control = msg_control
      (!____ptr).msg_controllen = msg_controllen
      (!____ptr).msg_flags = msg_flags
      ____ptr
    extension (struct: msghdr)
      def msg_name: Ptr[Byte] = struct._1
      def msg_name_=(value: Ptr[Byte]): Unit = !struct.at1 = value
      def msg_namelen: socklen_t = struct._2
      def msg_namelen_=(value: socklen_t): Unit = !struct.at2 = value
      def msg_iov: Ptr[iovec] = struct._3
      def msg_iov_=(value: Ptr[iovec]): Unit = !struct.at3 = value
      def msg_iovlen: CInt = struct._4
      def msg_iovlen_=(value: CInt): Unit = !struct.at4 = value
      def msg_control: Ptr[Byte] = struct._5
      def msg_control_=(value: Ptr[Byte]): Unit = !struct.at5 = value
      def msg_controllen: socklen_t = struct._6
      def msg_controllen_=(value: socklen_t): Unit = !struct.at6 = value
      def msg_flags: CInt = struct._7
      def msg_flags_=(value: CInt): Unit = !struct.at7 = value

  opaque type sa_endpoints = CStruct5[CUnsignedInt, Ptr[sockaddr], socklen_t, Ptr[sockaddr], socklen_t]
  object sa_endpoints:
    opaque type Struct0 = CStruct0
    object Struct0:
      given _tag: Tag[Struct0] = Tag.materializeCStruct0Tag
    given _tag: Tag[sa_endpoints] = Tag.materializeCStruct5Tag[CUnsignedInt, Ptr[sockaddr], socklen_t, Ptr[sockaddr], socklen_t]
    def apply()(using Zone): Ptr[sa_endpoints] = scala.scalanative.unsafe.alloc[sa_endpoints](1)
    def apply(sae_srcif: CUnsignedInt, sae_srcaddr: Ptr[sockaddr], sae_srcaddrlen: socklen_t, sae_dstaddr: Ptr[sockaddr], sae_dstaddrlen: socklen_t)(using Zone): Ptr[sa_endpoints] = 
      val ____ptr = apply()
      (!____ptr).sae_srcif = sae_srcif
      (!____ptr).sae_srcaddr = sae_srcaddr
      (!____ptr).sae_srcaddrlen = sae_srcaddrlen
      (!____ptr).sae_dstaddr = sae_dstaddr
      (!____ptr).sae_dstaddrlen = sae_dstaddrlen
      ____ptr
    extension (struct: sa_endpoints)
      def sae_srcif: CUnsignedInt = struct._1
      def sae_srcif_=(value: CUnsignedInt): Unit = !struct.at1 = value
      def sae_srcaddr: Ptr[sockaddr] = struct._2
      def sae_srcaddr_=(value: Ptr[sockaddr]): Unit = !struct.at2 = value
      def sae_srcaddrlen: socklen_t = struct._3
      def sae_srcaddrlen_=(value: socklen_t): Unit = !struct.at3 = value
      def sae_dstaddr: Ptr[sockaddr] = struct._4
      def sae_dstaddr_=(value: Ptr[sockaddr]): Unit = !struct.at4 = value
      def sae_dstaddrlen: socklen_t = struct._5
      def sae_dstaddrlen_=(value: socklen_t): Unit = !struct.at5 = value

  opaque type sa_endpoints_t = CStruct5[CUnsignedInt, Ptr[sockaddr], socklen_t, Ptr[sockaddr], socklen_t]
  object sa_endpoints_t:
    opaque type Struct0 = CStruct0
    object Struct0:
      given _tag: Tag[Struct0] = Tag.materializeCStruct0Tag
    given _tag: Tag[sa_endpoints_t] = Tag.materializeCStruct5Tag[CUnsignedInt, Ptr[sockaddr], socklen_t, Ptr[sockaddr], socklen_t]
    def apply()(using Zone): Ptr[sa_endpoints_t] = scala.scalanative.unsafe.alloc[sa_endpoints_t](1)
    def apply(sae_srcif: CUnsignedInt, sae_srcaddr: Ptr[sockaddr], sae_srcaddrlen: socklen_t, sae_dstaddr: Ptr[sockaddr], sae_dstaddrlen: socklen_t)(using Zone): Ptr[sa_endpoints_t] = 
      val ____ptr = apply()
      (!____ptr).sae_srcif = sae_srcif
      (!____ptr).sae_srcaddr = sae_srcaddr
      (!____ptr).sae_srcaddrlen = sae_srcaddrlen
      (!____ptr).sae_dstaddr = sae_dstaddr
      (!____ptr).sae_dstaddrlen = sae_dstaddrlen
      ____ptr
    extension (struct: sa_endpoints_t)
      def sae_srcif: CUnsignedInt = struct._1
      def sae_srcif_=(value: CUnsignedInt): Unit = !struct.at1 = value
      def sae_srcaddr: Ptr[sockaddr] = struct._2
      def sae_srcaddr_=(value: Ptr[sockaddr]): Unit = !struct.at2 = value
      def sae_srcaddrlen: socklen_t = struct._3
      def sae_srcaddrlen_=(value: socklen_t): Unit = !struct.at3 = value
      def sae_dstaddr: Ptr[sockaddr] = struct._4
      def sae_dstaddr_=(value: Ptr[sockaddr]): Unit = !struct.at4 = value
      def sae_dstaddrlen: socklen_t = struct._5
      def sae_dstaddrlen_=(value: socklen_t): Unit = !struct.at5 = value

  opaque type sf_hdtr = CStruct4[Ptr[iovec], CInt, Ptr[iovec], CInt]
  object sf_hdtr:
    given _tag: Tag[sf_hdtr] = Tag.materializeCStruct4Tag[Ptr[iovec], CInt, Ptr[iovec], CInt]
    def apply()(using Zone): Ptr[sf_hdtr] = scala.scalanative.unsafe.alloc[sf_hdtr](1)
    def apply(headers: Ptr[iovec], hdr_cnt: CInt, trailers: Ptr[iovec], trl_cnt: CInt)(using Zone): Ptr[sf_hdtr] = 
      val ____ptr = apply()
      (!____ptr).headers = headers
      (!____ptr).hdr_cnt = hdr_cnt
      (!____ptr).trailers = trailers
      (!____ptr).trl_cnt = trl_cnt
      ____ptr
    extension (struct: sf_hdtr)
      def headers: Ptr[iovec] = struct._1
      def headers_=(value: Ptr[iovec]): Unit = !struct.at1 = value
      def hdr_cnt: CInt = struct._2
      def hdr_cnt_=(value: CInt): Unit = !struct.at2 = value
      def trailers: Ptr[iovec] = struct._3
      def trailers_=(value: Ptr[iovec]): Unit = !struct.at3 = value
      def trl_cnt: CInt = struct._4
      def trl_cnt_=(value: CInt): Unit = !struct.at4 = value

  opaque type so_np_extensions = CStruct2[u_int32_t, u_int32_t]
  object so_np_extensions:
    given _tag: Tag[so_np_extensions] = Tag.materializeCStruct2Tag[u_int32_t, u_int32_t]
    def apply()(using Zone): Ptr[so_np_extensions] = scala.scalanative.unsafe.alloc[so_np_extensions](1)
    def apply(npx_flags: u_int32_t, npx_mask: u_int32_t)(using Zone): Ptr[so_np_extensions] = 
      val ____ptr = apply()
      (!____ptr).npx_flags = npx_flags
      (!____ptr).npx_mask = npx_mask
      ____ptr
    extension (struct: so_np_extensions)
      def npx_flags: u_int32_t = struct._1
      def npx_flags_=(value: u_int32_t): Unit = !struct.at1 = value
      def npx_mask: u_int32_t = struct._2
      def npx_mask_=(value: u_int32_t): Unit = !struct.at2 = value

  opaque type sockaddr = CStruct3[__uint8_t, sa_family_t, CArray[CChar, Nat.Digit2[Nat._1, Nat._4]]]
  object sockaddr:
    given _tag: Tag[sockaddr] = Tag.materializeCStruct3Tag[__uint8_t, sa_family_t, CArray[CChar, Nat.Digit2[Nat._1, Nat._4]]]
    def apply()(using Zone): Ptr[sockaddr] = scala.scalanative.unsafe.alloc[sockaddr](1)
    def apply(sa_len: __uint8_t, sa_family: sa_family_t, sa_data: CArray[CChar, Nat.Digit2[Nat._1, Nat._4]])(using Zone): Ptr[sockaddr] = 
      val ____ptr = apply()
      (!____ptr).sa_len = sa_len
      (!____ptr).sa_family = sa_family
      (!____ptr).sa_data = sa_data
      ____ptr
    extension (struct: sockaddr)
      def sa_len: __uint8_t = struct._1
      def sa_len_=(value: __uint8_t): Unit = !struct.at1 = value
      def sa_family: sa_family_t = struct._2
      def sa_family_=(value: sa_family_t): Unit = !struct.at2 = value
      def sa_data: CArray[CChar, Nat.Digit2[Nat._1, Nat._4]] = struct._3
      def sa_data_=(value: CArray[CChar, Nat.Digit2[Nat._1, Nat._4]]): Unit = !struct.at3 = value

  opaque type sockaddr_storage = CStruct5[__uint8_t, sa_family_t, CArray[CChar, Nat._6], __int64_t, CArray[CChar, Nat.Digit3[Nat._1, Nat._1, Nat._2]]]
  object sockaddr_storage:
    given _tag: Tag[sockaddr_storage] = Tag.materializeCStruct5Tag[__uint8_t, sa_family_t, CArray[CChar, Nat._6], __int64_t, CArray[CChar, Nat.Digit3[Nat._1, Nat._1, Nat._2]]]
    def apply()(using Zone): Ptr[sockaddr_storage] = scala.scalanative.unsafe.alloc[sockaddr_storage](1)
    def apply(ss_len: __uint8_t, ss_family: sa_family_t, __ss_pad1: CArray[CChar, Nat._6], __ss_align: __int64_t, __ss_pad2: CArray[CChar, Nat.Digit3[Nat._1, Nat._1, Nat._2]])(using Zone): Ptr[sockaddr_storage] = 
      val ____ptr = apply()
      (!____ptr).ss_len = ss_len
      (!____ptr).ss_family = ss_family
      (!____ptr).__ss_pad1 = __ss_pad1
      (!____ptr).__ss_align = __ss_align
      (!____ptr).__ss_pad2 = __ss_pad2
      ____ptr
    extension (struct: sockaddr_storage)
      def ss_len: __uint8_t = struct._1
      def ss_len_=(value: __uint8_t): Unit = !struct.at1 = value
      def ss_family: sa_family_t = struct._2
      def ss_family_=(value: sa_family_t): Unit = !struct.at2 = value
      def __ss_pad1: CArray[CChar, Nat._6] = struct._3
      def __ss_pad1_=(value: CArray[CChar, Nat._6]): Unit = !struct.at3 = value
      def __ss_align: __int64_t = struct._4
      def __ss_align_=(value: __int64_t): Unit = !struct.at4 = value
      def __ss_pad2: CArray[CChar, Nat.Digit3[Nat._1, Nat._1, Nat._2]] = struct._5
      def __ss_pad2_=(value: CArray[CChar, Nat.Digit3[Nat._1, Nat._1, Nat._2]]): Unit = !struct.at5 = value

  opaque type sockproto = CStruct2[__uint16_t, __uint16_t]
  object sockproto:
    given _tag: Tag[sockproto] = Tag.materializeCStruct2Tag[__uint16_t, __uint16_t]
    def apply()(using Zone): Ptr[sockproto] = scala.scalanative.unsafe.alloc[sockproto](1)
    def apply(sp_family: __uint16_t, sp_protocol: __uint16_t)(using Zone): Ptr[sockproto] = 
      val ____ptr = apply()
      (!____ptr).sp_family = sp_family
      (!____ptr).sp_protocol = sp_protocol
      ____ptr
    extension (struct: sockproto)
      def sp_family: __uint16_t = struct._1
      def sp_family_=(value: __uint16_t): Unit = !struct.at1 = value
      def sp_protocol: __uint16_t = struct._2
      def sp_protocol_=(value: __uint16_t): Unit = !struct.at2 = value

  opaque type timespec = CStruct2[__darwin_time_t, CLongInt]
  object timespec:
    given _tag: Tag[timespec] = Tag.materializeCStruct2Tag[__darwin_time_t, CLongInt]
    def apply()(using Zone): Ptr[timespec] = scala.scalanative.unsafe.alloc[timespec](1)
    def apply(tv_sec: __darwin_time_t, tv_nsec: CLongInt)(using Zone): Ptr[timespec] = 
      val ____ptr = apply()
      (!____ptr).tv_sec = tv_sec
      (!____ptr).tv_nsec = tv_nsec
      ____ptr
    extension (struct: timespec)
      def tv_sec: __darwin_time_t = struct._1
      def tv_sec_=(value: __darwin_time_t): Unit = !struct.at1 = value
      def tv_nsec: CLongInt = struct._2
      def tv_nsec_=(value: CLongInt): Unit = !struct.at2 = value

  opaque type timeval = CStruct2[__darwin_time_t, __darwin_suseconds_t]
  object timeval:
    given _tag: Tag[timeval] = Tag.materializeCStruct2Tag[__darwin_time_t, __darwin_suseconds_t]
    def apply()(using Zone): Ptr[timeval] = scala.scalanative.unsafe.alloc[timeval](1)
    def apply(tv_sec: __darwin_time_t, tv_usec: __darwin_suseconds_t)(using Zone): Ptr[timeval] = 
      val ____ptr = apply()
      (!____ptr).tv_sec = tv_sec
      (!____ptr).tv_usec = tv_usec
      ____ptr
    extension (struct: timeval)
      def tv_sec: __darwin_time_t = struct._1
      def tv_sec_=(value: __darwin_time_t): Unit = !struct.at1 = value
      def tv_usec: __darwin_suseconds_t = struct._2
      def tv_usec_=(value: __darwin_suseconds_t): Unit = !struct.at2 = value

  opaque type timeval64 = CStruct2[__int64_t, __int64_t]
  object timeval64:
    given _tag: Tag[timeval64] = Tag.materializeCStruct2Tag[__int64_t, __int64_t]
    def apply()(using Zone): Ptr[timeval64] = scala.scalanative.unsafe.alloc[timeval64](1)
    def apply(tv_sec: __int64_t, tv_usec: __int64_t)(using Zone): Ptr[timeval64] = 
      val ____ptr = apply()
      (!____ptr).tv_sec = tv_sec
      (!____ptr).tv_usec = tv_usec
      ____ptr
    extension (struct: timeval64)
      def tv_sec: __int64_t = struct._1
      def tv_sec_=(value: __int64_t): Unit = !struct.at1 = value
      def tv_usec: __int64_t = struct._2
      def tv_usec_=(value: __int64_t): Unit = !struct.at2 = value

  opaque type timezone = CStruct2[CInt, CInt]
  object timezone:
    given _tag: Tag[timezone] = Tag.materializeCStruct2Tag[CInt, CInt]
    def apply()(using Zone): Ptr[timezone] = scala.scalanative.unsafe.alloc[timezone](1)
    def apply(tz_minuteswest: CInt, tz_dsttime: CInt)(using Zone): Ptr[timezone] = 
      val ____ptr = apply()
      (!____ptr).tz_minuteswest = tz_minuteswest
      (!____ptr).tz_dsttime = tz_dsttime
      ____ptr
    extension (struct: timezone)
      def tz_minuteswest: CInt = struct._1
      def tz_minuteswest_=(value: CInt): Unit = !struct.at1 = value
      def tz_dsttime: CInt = struct._2
      def tz_dsttime_=(value: CInt): Unit = !struct.at2 = value

  opaque type tm = CStruct11[CInt, CInt, CInt, CInt, CInt, CInt, CInt, CInt, CInt, CLongInt, CString]
  object tm:
    given _tag: Tag[tm] = Tag.materializeCStruct11Tag[CInt, CInt, CInt, CInt, CInt, CInt, CInt, CInt, CInt, CLongInt, CString]
    def apply()(using Zone): Ptr[tm] = scala.scalanative.unsafe.alloc[tm](1)
    def apply(tm_sec: CInt, tm_min: CInt, tm_hour: CInt, tm_mday: CInt, tm_mon: CInt, tm_year: CInt, tm_wday: CInt, tm_yday: CInt, tm_isdst: CInt, tm_gmtoff: CLongInt, tm_zone: CString)(using Zone): Ptr[tm] = 
      val ____ptr = apply()
      (!____ptr).tm_sec = tm_sec
      (!____ptr).tm_min = tm_min
      (!____ptr).tm_hour = tm_hour
      (!____ptr).tm_mday = tm_mday
      (!____ptr).tm_mon = tm_mon
      (!____ptr).tm_year = tm_year
      (!____ptr).tm_wday = tm_wday
      (!____ptr).tm_yday = tm_yday
      (!____ptr).tm_isdst = tm_isdst
      (!____ptr).tm_gmtoff = tm_gmtoff
      (!____ptr).tm_zone = tm_zone
      ____ptr
    extension (struct: tm)
      def tm_sec: CInt = struct._1
      def tm_sec_=(value: CInt): Unit = !struct.at1 = value
      def tm_min: CInt = struct._2
      def tm_min_=(value: CInt): Unit = !struct.at2 = value
      def tm_hour: CInt = struct._3
      def tm_hour_=(value: CInt): Unit = !struct.at3 = value
      def tm_mday: CInt = struct._4
      def tm_mday_=(value: CInt): Unit = !struct.at4 = value
      def tm_mon: CInt = struct._5
      def tm_mon_=(value: CInt): Unit = !struct.at5 = value
      def tm_year: CInt = struct._6
      def tm_year_=(value: CInt): Unit = !struct.at6 = value
      def tm_wday: CInt = struct._7
      def tm_wday_=(value: CInt): Unit = !struct.at7 = value
      def tm_yday: CInt = struct._8
      def tm_yday_=(value: CInt): Unit = !struct.at8 = value
      def tm_isdst: CInt = struct._9
      def tm_isdst_=(value: CInt): Unit = !struct.at9 = value
      def tm_gmtoff: CLongInt = struct._10
      def tm_gmtoff_=(value: CLongInt): Unit = !struct.at10 = value
      def tm_zone: CString = struct._11
      def tm_zone_=(value: CString): Unit = !struct.at11 = value
  opaque type __mbstate_t = CArray[Byte, Nat.Digit3[Nat._1, Nat._2, Nat._8]]
  object __mbstate_t:
    given _tag: Tag[__mbstate_t] = Tag.CArray[CChar, Nat.Digit3[Nat._1, Nat._2, Nat._8]](Tag.Byte, Tag.Digit3[Nat._1, Nat._2, Nat._8](Tag.Nat1, Tag.Nat2, Tag.Nat8))
    extension (struct: __mbstate_t)
      def __mbstate8: CArray[CChar, Nat.Digit3[Nat._1, Nat._2, Nat._8]] = !struct.at(0).asInstanceOf[Ptr[CArray[CChar, Nat.Digit3[Nat._1, Nat._2, Nat._8]]]]
      def _mbstateL: CLongLong = !struct.at(0).asInstanceOf[Ptr[CLongLong]]
@link("curl")
@extern
private[libcurl] object extern_functions: 
  import types.*

  def OSReadSwapInt16(_base: Ptr[Byte], _offset: uintptr_t): uint16_t = extern

  def OSReadSwapInt32(_base: Ptr[Byte], _offset: uintptr_t): uint32_t = extern

  def OSReadSwapInt64(_base: Ptr[Byte], _offset: uintptr_t): uint64_t = extern

  def OSWriteSwapInt16(_base: Ptr[Byte], _offset: uintptr_t, _data: uint16_t): Unit = extern

  def OSWriteSwapInt32(_base: Ptr[Byte], _offset: uintptr_t, _data: uint32_t): Unit = extern

  def OSWriteSwapInt64(_base: Ptr[Byte], _offset: uintptr_t, _data: uint64_t): Unit = extern

  def _OSSwapInt16(_data: uint16_t): uint16_t = extern

  def _OSSwapInt32(_data: uint32_t): uint32_t = extern

  def _OSSwapInt64(_data: uint64_t): uint64_t = extern

  def __darwin_check_fd_set(_a: CInt, _b: Ptr[Byte]): CInt = extern

  def __darwin_check_fd_set_overflow(_0: CInt, _1: Ptr[Byte], _2: CInt): CInt = extern

  def __darwin_fd_clr(_fd: CInt, _p: Ptr[fd_set]): Unit = extern

  def __darwin_fd_isset(_fd: CInt, _p: Ptr[fd_set]): CInt = extern

  def __darwin_fd_set(_fd: CInt, _p: Ptr[fd_set]): Unit = extern

  def __snprintf_chk(_0: CString, _1: size_t, _2: CInt, _3: size_t, _4: CString): CInt = extern

  def __sprintf_chk(_0: CString, _1: CInt, _2: size_t, _3: CString): CInt = extern

  def __sputc(_c: CInt, _p: Ptr[FILE]): CInt = extern

  def __srget(_0: Ptr[FILE]): CInt = extern

  def __svfscanf(_0: Ptr[FILE], _1: CString, _2: va_list): CInt = extern

  def __swbuf(_0: CInt, _1: Ptr[FILE]): CInt = extern

  def __vsnprintf_chk(_0: CString, _1: size_t, _2: CInt, _3: size_t, _4: CString, _5: va_list): CInt = extern

  def __vsprintf_chk(_0: CString, _1: CInt, _2: size_t, _3: CString, _4: va_list): CInt = extern

  def accept(_0: CInt, _1: Ptr[sockaddr], _2: Ptr[socklen_t]): CInt = extern

  def adjtime(_0: Ptr[timeval], _1: Ptr[timeval]): CInt = extern

  def asctime(_0: Ptr[tm]): CString = extern

  def asctime_r(_0: Ptr[tm], _1: CString): CString = extern

  def asprintf(_0: Ptr[CString], _1: CString): CInt = extern

  def bind(_0: CInt, _1: Ptr[sockaddr], _2: socklen_t): CInt = extern

  def clearerr(_0: Ptr[FILE]): Unit = extern

  def clock(): clock_t = extern

  def clock_getres(__clock_id: clockid_t, __res: Ptr[timespec]): CInt = extern

  def clock_gettime(__clock_id: clockid_t, __tp: Ptr[timespec]): CInt = extern

  def clock_gettime_nsec_np(__clock_id: clockid_t): __uint64_t = extern

  def clock_settime(__clock_id: clockid_t, __tp: Ptr[timespec]): CInt = extern

  def connect(_0: CInt, _1: Ptr[sockaddr], _2: socklen_t): CInt = extern

  def connectx(_0: CInt, _1: Ptr[sa_endpoints_t], _2: sae_associd_t, _3: CUnsignedInt, _4: Ptr[iovec], _5: CUnsignedInt, _6: Ptr[size_t], _7: Ptr[sae_connid_t]): CInt = extern

  def ctermid(_0: CString): CString = extern

  def ctermid_r(_0: CString): CString = extern

  def ctime(_0: Ptr[time_t]): CString = extern

  def ctime_r(_0: Ptr[time_t], _1: CString): CString = extern

  def curl_easy_cleanup(curl: Ptr[CURL]): Unit = extern

  def curl_easy_duphandle(curl: Ptr[CURL]): Ptr[CURL] = extern

  def curl_easy_escape(handle: Ptr[CURL], string: CString, length: CInt): CString = extern

  def curl_easy_getinfo(curl: Ptr[CURL], info: CURLINFO): CURLcode = extern

  def curl_easy_init(): Ptr[CURL] = extern

  def curl_easy_option_by_id(id: CURLoption): Ptr[curl_easyoption] = extern

  def curl_easy_option_by_name(name: CString): Ptr[curl_easyoption] = extern

  def curl_easy_option_next(prev: Ptr[curl_easyoption]): Ptr[curl_easyoption] = extern

  def curl_easy_pause(handle: Ptr[CURL], bitmask: CInt): CURLcode = extern

  def curl_easy_perform(curl: Ptr[CURL]): CURLcode = extern

  def curl_easy_recv(curl: Ptr[CURL], buffer: Ptr[Byte], buflen: size_t, n: Ptr[size_t]): CURLcode = extern

  def curl_easy_reset(curl: Ptr[CURL]): Unit = extern

  def curl_easy_send(curl: Ptr[CURL], buffer: Ptr[Byte], buflen: size_t, n: Ptr[size_t]): CURLcode = extern

  def curl_easy_setopt(curl: Ptr[CURL], option: CURLoption): CURLcode = extern

  def curl_easy_strerror(_0: CURLcode): CString = extern

  def curl_easy_unescape(handle: Ptr[CURL], string: CString, length: CInt, outlength: Ptr[CInt]): CString = extern

  def curl_easy_upkeep(curl: Ptr[CURL]): CURLcode = extern

  def curl_escape(string: CString, length: CInt): CString = extern

  def curl_formadd(httppost: Ptr[Ptr[curl_httppost]], last_post: Ptr[Ptr[curl_httppost]]): CURLFORMcode = extern

  def curl_formfree(form: Ptr[curl_httppost]): Unit = extern

  def curl_formget(form: Ptr[curl_httppost], arg: Ptr[Byte], append: curl_formget_callback): CInt = extern

  def curl_free(p: Ptr[Byte]): Unit = extern

  def curl_getdate(p: CString, unused: Ptr[time_t]): time_t = extern

  def curl_getenv(variable: CString): CString = extern

  def curl_global_cleanup(): Unit = extern

  def curl_global_init(flags: CLongInt): CURLcode = extern

  def curl_global_init_mem(flags: CLongInt, m: curl_malloc_callback, f: curl_free_callback, r: curl_realloc_callback, s: curl_strdup_callback, c: curl_calloc_callback): CURLcode = extern

  def curl_global_sslset(id: curl_sslbackend, name: CString, avail: Ptr[Ptr[Ptr[curl_ssl_backend]]]): CURLsslset = extern

  def curl_mime_addpart(mime: Ptr[curl_mime]): Ptr[curl_mimepart] = extern

  def curl_mime_data(part: Ptr[curl_mimepart], data: CString, datasize: size_t): CURLcode = extern

  def curl_mime_data_cb(part: Ptr[curl_mimepart], datasize: curl_off_t, readfunc: curl_read_callback, seekfunc: curl_seek_callback, freefunc: curl_free_callback, arg: Ptr[Byte]): CURLcode = extern

  def curl_mime_encoder(part: Ptr[curl_mimepart], encoding: CString): CURLcode = extern

  def curl_mime_filedata(part: Ptr[curl_mimepart], filename: CString): CURLcode = extern

  def curl_mime_filename(part: Ptr[curl_mimepart], filename: CString): CURLcode = extern

  def curl_mime_free(mime: Ptr[curl_mime]): Unit = extern

  def curl_mime_headers(part: Ptr[curl_mimepart], headers: Ptr[curl_slist], take_ownership: CInt): CURLcode = extern

  def curl_mime_init(easy: Ptr[CURL]): Ptr[curl_mime] = extern

  def curl_mime_name(part: Ptr[curl_mimepart], name: CString): CURLcode = extern

  def curl_mime_subparts(part: Ptr[curl_mimepart], subparts: Ptr[curl_mime]): CURLcode = extern

  def curl_mime_type(part: Ptr[curl_mimepart], mimetype: CString): CURLcode = extern

  def curl_multi_add_handle(multi_handle: Ptr[CURLM], curl_handle: Ptr[CURL]): CURLMcode = extern

  def curl_multi_assign(multi_handle: Ptr[CURLM], sockfd: curl_socket_t, sockp: Ptr[Byte]): CURLMcode = extern

  def curl_multi_cleanup(multi_handle: Ptr[CURLM]): CURLMcode = extern

  def curl_multi_fdset(multi_handle: Ptr[CURLM], read_fd_set: Ptr[fd_set], write_fd_set: Ptr[fd_set], exc_fd_set: Ptr[fd_set], max_fd: Ptr[CInt]): CURLMcode = extern

  def curl_multi_info_read(multi_handle: Ptr[CURLM], msgs_in_queue: Ptr[CInt]): Ptr[CURLMsg] = extern

  def curl_multi_init(): Ptr[CURLM] = extern

  def curl_multi_perform(multi_handle: Ptr[CURLM], running_handles: Ptr[CInt]): CURLMcode = extern

  def curl_multi_poll(multi_handle: Ptr[CURLM], extra_fds: Unit, extra_nfds: CUnsignedInt, timeout_ms: CInt, ret: Ptr[CInt]): CURLMcode = extern

  def curl_multi_remove_handle(multi_handle: Ptr[CURLM], curl_handle: Ptr[CURL]): CURLMcode = extern

  def curl_multi_setopt(multi_handle: Ptr[CURLM], option: CURLMoption): CURLMcode = extern

  def curl_multi_socket(multi_handle: Ptr[CURLM], s: curl_socket_t, running_handles: Ptr[CInt]): CURLMcode = extern

  def curl_multi_socket_action(multi_handle: Ptr[CURLM], s: curl_socket_t, ev_bitmask: CInt, running_handles: Ptr[CInt]): CURLMcode = extern

  def curl_multi_socket_all(multi_handle: Ptr[CURLM], running_handles: Ptr[CInt]): CURLMcode = extern

  def curl_multi_strerror(_0: CURLMcode): CString = extern

  def curl_multi_timeout(multi_handle: Ptr[CURLM], milliseconds: Ptr[CLongInt]): CURLMcode = extern

  def curl_multi_wait(multi_handle: Ptr[CURLM], extra_fds: Unit, extra_nfds: CUnsignedInt, timeout_ms: CInt, ret: Ptr[CInt]): CURLMcode = extern

  def curl_multi_wakeup(multi_handle: Ptr[CURLM]): CURLMcode = extern

  def curl_pushheader_byname(h: Ptr[curl_pushheaders], name: CString): CString = extern

  def curl_pushheader_bynum(h: Ptr[curl_pushheaders], num: size_t): CString = extern

  def curl_share_cleanup(_0: Ptr[CURLSH]): CURLSHcode = extern

  def curl_share_init(): Ptr[CURLSH] = extern

  def curl_share_setopt(_0: Ptr[CURLSH], option: CURLSHoption): CURLSHcode = extern

  def curl_share_strerror(_0: CURLSHcode): CString = extern

  def curl_slist_append(_0: Ptr[curl_slist], _1: CString): Ptr[curl_slist] = extern

  def curl_slist_free_all(_0: Ptr[curl_slist]): Unit = extern

  def curl_strequal(s1: CString, s2: CString): CInt = extern

  def curl_strnequal(s1: CString, s2: CString, n: size_t): CInt = extern

  def curl_unescape(string: CString, length: CInt): CString = extern

  def curl_url(): Ptr[CURLU] = extern

  def curl_url_cleanup(handle: Ptr[CURLU]): Unit = extern

  def curl_url_dup(in: Ptr[CURLU]): Ptr[CURLU] = extern

  def curl_url_get(handle: Ptr[CURLU], what: CURLUPart, part: Ptr[CString], flags: CUnsignedInt): CURLUcode = extern

  def curl_url_set(handle: Ptr[CURLU], what: CURLUPart, part: CString, flags: CUnsignedInt): CURLUcode = extern

  def curl_version(): CString = extern

  def curl_version_info(_0: CURLversion): Ptr[curl_version_info_data] = extern

  def difftime(_0: time_t, _1: time_t): Double = extern

  def disconnectx(_0: CInt, _1: sae_associd_t, _2: sae_connid_t): CInt = extern

  def dprintf(_0: CInt, _1: CString): CInt = extern

  def fclose(_0: Ptr[FILE]): CInt = extern

  def fdopen(_0: CInt, _1: CString): Ptr[FILE] = extern

  def feof(_0: Ptr[FILE]): CInt = extern

  def ferror(_0: Ptr[FILE]): CInt = extern

  def fflush(_0: Ptr[FILE]): CInt = extern

  def fgetc(_0: Ptr[FILE]): CInt = extern

  def fgetln(_0: Ptr[FILE], _1: Ptr[size_t]): CString = extern

  def fgetpos(_0: Ptr[FILE], _1: Ptr[fpos_t]): CInt = extern

  def fgets(_0: CString, _1: CInt, _2: Ptr[FILE]): CString = extern

  def fileno(_0: Ptr[FILE]): CInt = extern

  def flockfile(_0: Ptr[FILE]): Unit = extern

  def fmemopen(__buf: Ptr[Byte], __size: size_t, __mode: CString): Ptr[FILE] = extern

  def fmtcheck(_0: CString, _1: CString): CString = extern

  def fopen(__filename: CString, __mode: CString): Ptr[FILE] = extern

  def fprintf(_0: Ptr[FILE], _1: CString): CInt = extern

  def fpurge(_0: Ptr[FILE]): CInt = extern

  def fputc(_0: CInt, _1: Ptr[FILE]): CInt = extern

  def fputs(_0: CString, _1: Ptr[FILE]): CInt = extern

  def fread(__ptr: Ptr[Byte], __size: size_t, __nitems: size_t, __stream: Ptr[FILE]): CUnsignedLongInt = extern

  def freopen(_0: CString, _1: CString, _2: Ptr[FILE]): Ptr[FILE] = extern

  def fscanf(_0: Ptr[FILE], _1: CString): CInt = extern

  def fseek(_0: Ptr[FILE], _1: CLongInt, _2: CInt): CInt = extern

  def fseeko(__stream: Ptr[FILE], __offset: off_t, __whence: CInt): CInt = extern

  def fsetpos(_0: Ptr[FILE], _1: Ptr[fpos_t]): CInt = extern

  def ftell(_0: Ptr[FILE]): CLongInt = extern

  def ftello(__stream: Ptr[FILE]): off_t = extern

  def ftrylockfile(_0: Ptr[FILE]): CInt = extern

  def funlockfile(_0: Ptr[FILE]): Unit = extern

  def funopen(_0: Ptr[Byte], _1: CFuncPtr3[Ptr[Byte], CString, CInt, CInt], _2: CFuncPtr3[Ptr[Byte], CString, CInt, CInt], _3: CFuncPtr3[Ptr[Byte], fpos_t, CInt, fpos_t], _4: CFuncPtr1[Ptr[Byte], CInt]): Ptr[FILE] = extern

  def futimes(_0: CInt, _1: Ptr[timeval]): CInt = extern

  def fwrite(__ptr: Ptr[Byte], __size: size_t, __nitems: size_t, __stream: Ptr[FILE]): CUnsignedLongInt = extern

  def getc(_0: Ptr[FILE]): CInt = extern

  def getc_unlocked(_0: Ptr[FILE]): CInt = extern

  def getchar(): CInt = extern

  def getchar_unlocked(): CInt = extern

  def getdate(_0: CString): Ptr[tm] = extern

  def getdelim(__linep: Ptr[CString], __linecapp: Ptr[size_t], __delimiter: CInt, __stream: Ptr[FILE]): ssize_t = extern

  def getitimer(_0: CInt, _1: Ptr[itimerval]): CInt = extern

  def getline(__linep: Ptr[CString], __linecapp: Ptr[size_t], __stream: Ptr[FILE]): ssize_t = extern

  def getpeername(_0: CInt, _1: Ptr[sockaddr], _2: Ptr[socklen_t]): CInt = extern

  def gets(_0: CString): CString = extern

  def getsockname(_0: CInt, _1: Ptr[sockaddr], _2: Ptr[socklen_t]): CInt = extern

  def getsockopt(_0: CInt, _1: CInt, _2: CInt, _3: Ptr[Byte], _4: Ptr[socklen_t]): CInt = extern

  def gettimeofday(_0: Ptr[timeval], _1: Ptr[Byte]): CInt = extern

  def getw(_0: Ptr[FILE]): CInt = extern

  def gmtime(_0: Ptr[time_t]): Ptr[tm] = extern

  def gmtime_r(_0: Ptr[time_t], _1: Ptr[tm]): Ptr[tm] = extern

  def listen(_0: CInt, _1: CInt): CInt = extern

  def localtime(_0: Ptr[time_t]): Ptr[tm] = extern

  def localtime_r(_0: Ptr[time_t], _1: Ptr[tm]): Ptr[tm] = extern

  def lutimes(_0: CString, _1: Ptr[timeval]): CInt = extern

  def mktime(_0: Ptr[tm]): time_t = extern

  def nanosleep(__rqtp: Ptr[timespec], __rmtp: Ptr[timespec]): CInt = extern

  def open_memstream(__bufp: Ptr[CString], __sizep: Ptr[size_t]): Ptr[FILE] = extern

  def pclose(_0: Ptr[FILE]): CInt = extern

  def perror(_0: CString): Unit = extern

  def pfctlinput(_0: CInt, _1: Ptr[sockaddr]): Unit = extern

  def popen(_0: CString, _1: CString): Ptr[FILE] = extern

  def posix2time(_0: time_t): time_t = extern

  def printf(_0: CString): CInt = extern

  def putc(_0: CInt, _1: Ptr[FILE]): CInt = extern

  def putc_unlocked(_0: CInt, _1: Ptr[FILE]): CInt = extern

  def putchar(_0: CInt): CInt = extern

  def putchar_unlocked(_0: CInt): CInt = extern

  def puts(_0: CString): CInt = extern

  def putw(_0: CInt, _1: Ptr[FILE]): CInt = extern

  def recv(_0: CInt, _1: Ptr[Byte], _2: size_t, _3: CInt): ssize_t = extern

  def recvfrom(_0: CInt, _1: Ptr[Byte], _2: size_t, _3: CInt, _4: Ptr[sockaddr], _5: Ptr[socklen_t]): ssize_t = extern

  def recvmsg(_0: CInt, _1: Ptr[msghdr], _2: CInt): ssize_t = extern

  def remove(_0: CString): CInt = extern

  def rename(__old: CString, __new: CString): CInt = extern

  def renameat(_0: CInt, _1: CString, _2: CInt, _3: CString): CInt = extern

  def renameatx_np(_0: CInt, _1: CString, _2: CInt, _3: CString, _4: CUnsignedInt): CInt = extern

  def renamex_np(_0: CString, _1: CString, _2: CUnsignedInt): CInt = extern

  def rewind(_0: Ptr[FILE]): Unit = extern

  def scanf(_0: CString): CInt = extern

  def select(_0: CInt, _1: Ptr[fd_set], _2: Ptr[fd_set], _3: Ptr[fd_set], _4: Ptr[timeval]): CInt = extern

  def send(_0: CInt, _1: Ptr[Byte], _2: size_t, _3: CInt): ssize_t = extern

  def sendfile(_0: CInt, _1: CInt, _2: off_t, _3: Ptr[off_t], _4: Ptr[sf_hdtr], _5: CInt): CInt = extern

  def sendmsg(_0: CInt, _1: Ptr[msghdr], _2: CInt): ssize_t = extern

  def sendto(_0: CInt, _1: Ptr[Byte], _2: size_t, _3: CInt, _4: Ptr[sockaddr], _5: socklen_t): ssize_t = extern

  def setbuf(_0: Ptr[FILE], _1: CString): Unit = extern

  def setbuffer(_0: Ptr[FILE], _1: CString, _2: CInt): Unit = extern

  def setitimer(_0: CInt, _1: Ptr[itimerval], _2: Ptr[itimerval]): CInt = extern

  def setlinebuf(_0: Ptr[FILE]): CInt = extern

  def setsockopt(_0: CInt, _1: CInt, _2: CInt, _3: Ptr[Byte], _4: socklen_t): CInt = extern

  def settimeofday(_0: Ptr[timeval], _1: Ptr[timezone]): CInt = extern

  def setvbuf(_0: Ptr[FILE], _1: CString, _2: CInt, _3: size_t): CInt = extern

  def shutdown(_0: CInt, _1: CInt): CInt = extern

  def snprintf(__str: CString, __size: size_t, __format: CString): CInt = extern

  def sockatmark(_0: CInt): CInt = extern

  def socket(_0: CInt, _1: CInt, _2: CInt): CInt = extern

  def socketpair(_0: CInt, _1: CInt, _2: CInt, _3: Ptr[CInt]): CInt = extern

  def sprintf(_0: CString, _1: CString): CInt = extern

  def sscanf(_0: CString, _1: CString): CInt = extern

  def strftime(_0: CString, _1: size_t, _2: CString, _3: Ptr[tm]): size_t = extern

  def strptime(_0: CString, _1: CString, _2: Ptr[tm]): CString = extern

  def tempnam(__dir: CString, __prefix: CString): CString = extern

  def time(_0: Ptr[time_t]): time_t = extern

  def time2posix(_0: time_t): time_t = extern

  def timegm(_0: Ptr[tm]): time_t = extern

  def timelocal(_0: Ptr[tm]): time_t = extern

  def timespec_get(ts: Ptr[timespec], base: CInt): CInt = extern

  def tmpfile(): Ptr[FILE] = extern

  def tmpnam(_0: CString): CString = extern

  def tzset(): Unit = extern

  def tzsetwall(): Unit = extern

  def ungetc(_0: CInt, _1: Ptr[FILE]): CInt = extern

  def utimes(_0: CString, _1: Ptr[timeval]): CInt = extern

  def vasprintf(_0: Ptr[CString], _1: CString, _2: va_list): CInt = extern

  def vdprintf(_0: CInt, _1: CString, _2: va_list): CInt = extern

  def vfprintf(_0: Ptr[FILE], _1: CString, _2: va_list): CInt = extern

  def vfscanf(__stream: Ptr[FILE], __format: CString, _2: va_list): CInt = extern

  def vprintf(_0: CString, _1: va_list): CInt = extern

  def vscanf(__format: CString, _1: va_list): CInt = extern

  def vsnprintf(__str: CString, __size: size_t, __format: CString, _3: va_list): CInt = extern

  def vsprintf(_0: CString, _1: CString, _2: va_list): CInt = extern

  def vsscanf(__str: CString, __format: CString, _2: va_list): CInt = extern

object functions: 
  import types.*, extern_functions.*

  export extern_functions.*


