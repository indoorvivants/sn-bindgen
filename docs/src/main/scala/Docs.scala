package bindgen.docs

import subatomic.builders.librarysite.*
import subatomic.builders.*
import subatomic.*
import java.time.LocalDate
import subatomic.builders.Tracker.GoogleAnalytics

def currentYear = LocalDate.now().getYear()

object Docs extends LibrarySite.App:
  def config =
    LibrarySite(
      name = "sn-bindgen",
      contentRoot = os.pwd / "pages",
      tagline = Some("Scala 3 Native binding generator to C libraries"),
      assetsRoot = Some(os.pwd / "assets"),
      copyright = Some(s"© 2021-$currentYear Anton Sviridov"),
      githubUrl = Some("https://github.com/indoorvivants/sn-bindgen"),
      trackers = Seq(GoogleAnalytics("G-2V7BY56Z37")),
      highlighting = SyntaxHighlighting.HighlightJS.default
        .copy(
          languages = List("scala", "c", "dockerfile"),
          theme = "stackoverflow-light"
        )
    )
  override def extra(site: Site[LibrarySite.Doc]) =
    site
      .addCopyOf(SiteRoot / "CNAME", os.pwd / "assets" / "CNAME")
end Docs
