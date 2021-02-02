package io.github.liquibase4s

import io.github.liquibase4s.IdentityMigrationHandler.Identity

trait MigrationHandler[F[_]] {
  def migrate(config: LiquibaseConfig): F[Unit]
  def validate(config: LiquibaseConfig): F[Unit]
}

object MigrationHandler {
  def apply[F[_]: MigrationHandler]: MigrationHandler[F] = implicitly[MigrationHandler[F]]

  implicit def defaultHandler: MigrationHandler[Identity] = IdentityMigrationHandler.handler
}
