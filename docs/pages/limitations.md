---
title: Limitations
---

<!--toc:start-->
- [Definitions like `#define SOME_VALUE 25` are not exported](#definitions-like-define-somevalue-25-are-not-exported)
- [Variadic functions](#variadic-functions)
<!--toc:end-->

## Definitions like `#define SOME_VALUE 25` are not exported

The world of C preprocessor directives is dark and impossible to formalise.
Potentially in the future we can add a mode to export the simplest of definitions
as global constants, but it's very limited and inflexible.

Currently we recommend adding C forwarder functions for those cases, e.g. in the example of OpenSSL:

```c
#include "openssl/evp.h"

// preprocessor constants
int get_EVP_MAC_KEY() { return EVP_PKEY_HMAC; }

int get_EVP_MAX_MD_SIZE() { return EVP_MAX_MD_SIZE; }

// macro definition
void get_OpenSSL_add_all_digests() { OpenSSL_add_all_digests(); }
```

## Variadic functions

Scala Native does support constructing a `va_list`, but a function taking such list must exist in the first place.

In the case of, for example, cURL, the [public interface](https://github.com/curl/curl/blob/master/include/curl/curl.h#L2889) is defined in terms of `...` and there's 
nothing in C that allows you to call a variadic function if all you have is a value of `va_list`.

The layout of said `va_list` also varies by platform.
