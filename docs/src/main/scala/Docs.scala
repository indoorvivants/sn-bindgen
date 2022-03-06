package bindgen.docs

import subatomic.builders.librarysite.*
import subatomic.builders.*
import subatomic.*
import java.time.LocalDate

def currentYear = LocalDate.now().getYear()

object Docs extends LibrarySite.App:
  def config =
    LibrarySite(
      name = "SN bindgen",
      contentRoot = os.pwd / "pages",
      highlighting = SyntaxHighlighting.HighlightJS.default
        .copy(theme = "androidstudio", languages = List("scala", "c")),
      tagline = Some("Scala 3 Native binding generator to C libraries"),
      assetsRoot = Some(os.pwd / "assets"),
      copyright = Some(s"© 2021-$currentYear Anton Sviridov"),
      githubUrl = Some("https://github.com/indoorvivants/sn-bindgen")
    )
  override def extra(site: Site[LibrarySite.Doc]) =
    site
      .addCopyOf(SiteRoot / "CNAME", os.pwd / "assets" / "CNAME")
end Docs
