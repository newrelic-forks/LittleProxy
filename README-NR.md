This is New Relic specific fork of LittleProxy.

We have filed a PR to the official project with multiple enhancements (and
more planned) but they haven't merged it yet. So we decided to go ahead and
keep a fork in the meanwhile.

The branch from which is possible to release is `nr`.
This branch is setup to release to New Relic internal Artifactory.

To build & release:

```bash
$ git checkout nr
$ mvn clean install
$ mvn -s nr-settings.xml deploy
```

Note that the `nr-settings.xml` is the file that contains the shared credentials
to upload to artifactory.

Hopefully this repo can go away as soon as we get the PR merged and a new
build published by the official project.

Nothing New Relic specific has been added: just a series of extra features that
we use for the **Synthetic Monitoring** product.
