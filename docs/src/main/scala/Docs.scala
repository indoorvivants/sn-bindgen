package bindgen.docs

import subatomic.builders.librarysite.*
import subatomic.builders.*

object Docs extends LibrarySite.App:
  def config =
    LibrarySite(
      name = "SN bindgen",
      contentRoot = os.pwd / "pages",
      highlighting =
        SyntaxHighlighting.HighlightJS.default.copy(theme = "monokai")
    )
