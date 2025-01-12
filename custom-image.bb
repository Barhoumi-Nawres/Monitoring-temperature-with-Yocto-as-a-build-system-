require recipes-core/images/core-image-minimal.bb

inherit extrausers

EXTRA_USERS_PARAMS = "\
    useradd pi; \
    usermod -p '${PI_USERPASS}' pi; \
"

PI_USERPASS = "\$6\$JonfphjDlFG1r5fD\$N3yBG5TkaxXPUg2hpW8ihSm.9Q2nE2Rh/yEmSfigKnagEdNvWIipN1hzCOLwStJC6BTeD4ePmzhHAcb./ydlL0"

